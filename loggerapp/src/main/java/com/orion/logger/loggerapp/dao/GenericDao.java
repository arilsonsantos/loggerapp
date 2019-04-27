package com.orion.logger.loggerapp.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orion.logger.loggerapp.model.Book;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericDao<T> {

    protected abstract RestHighLevelClient getClient();

    protected abstract ObjectMapper getObjectMapper();

    private Class<T> clazz;

    protected GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findById(String id) throws Exception {
        GetRequest getRequest = new GetRequest("jumia_log", "log", id);
        GetResponse getResponse = getClient().get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> resultMap = getResponse.getSource();

        return getObjectMapper().convertValue(resultMap, clazz);
    }

    public List<T> findAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest(Book.class.getSimpleName().toLowerCase());
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(query);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = getClient().search(searchRequest, RequestOptions.DEFAULT);

        RestStatus status = searchResponse.status();

        if (status == RestStatus.OK) {
            List<T> list = new ArrayList<>();
            SearchHit[] searchHit = searchResponse.getHits().getHits();
            if (searchHit.length > 0) {
                Arrays.stream(searchHit)
                        .forEach(hit -> list.add(getObjectMapper().convertValue(hit.getSourceAsMap(), clazz)));
            }
            return list;
        }
        return null;
    }
}
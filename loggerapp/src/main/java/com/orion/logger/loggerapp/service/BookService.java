package com.orion.logger.loggerapp.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookService {

    private RestHighLevelClient client;
    private ObjectMapper objectMapper;

    @Autowired
    public BookService(RestHighLevelClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public Book findById(String id) throws Exception {
        GetRequest getRequest = new GetRequest("jumia_log", "log", id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> resultMap = getResponse.getSource();

        return objectMapper.convertValue(resultMap, Book.class);
    }

    public SearchRequest Teste() throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        SearchRequest sb = searchRequest.source(searchSourceBuilder);
        return sb;
    }

    public List<Book> findAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest("jumia_log");
        searchRequest.types("log");
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery());
        //NativeSearchQuery nativeQuery = new NativeSearchQueryBuilder().withQuery(query).build();
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ssb.query(query);
        searchRequest.source(ssb);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        RestStatus status = searchResponse.status();
        
        if (status == RestStatus.OK) {
            List<Book> books = new ArrayList<>();
            SearchHit[] sh = searchResponse.getHits().getHits();
            if (sh.length > 0) {
                Arrays.stream(sh)
                        .forEach(hit -> books.add(objectMapper.convertValue(hit.getSourceAsMap(), Book.class)));
            }
            return books;
        }
        return null;
    }
}
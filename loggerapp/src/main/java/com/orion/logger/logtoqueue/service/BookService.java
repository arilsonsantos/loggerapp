package com.orion.logger.logtoqueue.service;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orion.logger.logtoqueue.model.Book;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
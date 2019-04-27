package com.orion.logger.loggerapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orion.logger.loggerapp.dao.GenericDao;
import com.orion.logger.loggerapp.model.Book;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class BookService extends GenericDao<Book> {

    @Inject
    RestHighLevelClient client;

    @Inject
    ObjectMapper objectMapper;

    public BookService() {
        super(Book.class);
    }

    @Override
    protected RestHighLevelClient getClient() {
        return client;
    }

    @Override
    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }

}
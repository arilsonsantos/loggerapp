package com.orion.loggerappdata.respository;

import com.orion.loggerappdata.model.Book;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * BookRespository
 */
@Repository
public interface BookRespository extends ElasticsearchRepository<Book, String> {

    
}
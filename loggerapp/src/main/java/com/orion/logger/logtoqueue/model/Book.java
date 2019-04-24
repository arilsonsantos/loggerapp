package com.orion.logger.logtoqueue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (indexName = "livraria", type = "book")
public class Book {

    @Id
    private String id;
    private String title;

}
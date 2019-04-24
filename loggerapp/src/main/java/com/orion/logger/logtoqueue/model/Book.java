package com.orion.logger.logtoqueue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document (indexName = "jumila_log", type = "log")
public class Book {

    @Id
    private String id;
    private String title;

}
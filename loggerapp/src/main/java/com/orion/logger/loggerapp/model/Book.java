package com.orion.logger.loggerapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document (indexName = "jumila_log", type = "log")
public class Book {

    @Id
    private int id;
    private String title;

}
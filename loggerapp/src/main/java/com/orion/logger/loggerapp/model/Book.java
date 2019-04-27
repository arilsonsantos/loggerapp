package com.orion.logger.loggerapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document (indexName = "jumila_log")
public class Book {

    @Id
    private int id;
    private String name;

}
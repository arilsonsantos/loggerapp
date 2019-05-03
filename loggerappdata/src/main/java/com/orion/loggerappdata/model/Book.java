package com.orion.loggerappdata.model;

import java.io.Serializable;

import com.orion.loggerappdata.logtype.ITypeLogA;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "book", type = "doc")
public class Book implements Serializable, ITypeLogA {

    private static final long serialVersionUID = 8739267093239391260L;

    @Id
    private String id;
    private String name;

}
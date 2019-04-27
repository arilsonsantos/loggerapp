package com.orion.logger.loggerapp.model;

import java.io.Serializable;

import com.orion.logger.loggerapp.logtype.ITypeLogA;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable, ITypeLogA {

    private static final long serialVersionUID = 8739267093239391260L;

    @Id
    private String id;
    private String name;

}
package com.orion.logger.logtoqueue.controller;

import com.orion.logger.logtoqueue.model.Book;
import com.orion.logger.logtoqueue.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api")
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService service) {

        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public Book findById(@PathVariable String id) throws Exception {
        log.info("acessando api");
        return service.findById(id);
    }

}
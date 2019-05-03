package com.orion.loggerappdata.controller;

import java.util.List;

import com.orion.loggerappdata.model.Book;
import com.orion.loggerappdata.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/logs")
public class BookController {

    @Autowired
    private BookService service;

    // public BookController(BookService service) {
    //     this.service = service;
    // }

    @GetMapping(path = "/{id}")
    public Book findById(@PathVariable String id) throws Exception {
        return service.findById(id);
    }

    @GetMapping
    public List<Book> findAll() throws Exception {
        return service.findAll();

    }

}
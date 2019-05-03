package com.orion.loggerappdata.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.orion.loggerappdata.model.Book;
import com.orion.loggerappdata.respository.BookRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService  {

    
    @Autowired
    BookRespository bookRespository;

    public Book findById(String id) {
        Optional<Book> book = bookRespository.findById(id);
        return book.orElseGet(null);
    }

    public List<Book> findAll() {
        Iterator<Book> iterator = bookRespository.findAll().iterator();
        List<Book> books = new ArrayList<>();
        while (iterator.hasNext()) {
            books.add(iterator.next());
        }
        return books;
    }
   
    

}
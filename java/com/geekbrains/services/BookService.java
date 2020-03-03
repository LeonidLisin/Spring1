package com.geekbrains.services;

import com.geekbrains.entities.Book;
import com.geekbrains.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBookList(){
        return (List<Book>)bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }
}

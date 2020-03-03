package com.geekbrains.controllers;

import com.geekbrains.entities.Book;
import com.geekbrains.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public String showBooks(Model model) {
        List<Book> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "show_books";
    }

    @RequestMapping(path="/add", method= RequestMethod.GET)
    public String showAddForm(Model model) {
        Book book = new Book();
        book.setTitle("Unknown");
        model.addAttribute("book", book);
        return "add_book";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Book book) {
        bookService.addBook(book);
        return "redirect:/books/list";
    }
}

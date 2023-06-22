package com.example.controllers;

import com.example.models.Book;
import com.example.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("searchQuery") String searchQuery, Model model) {
        List<Book> books = bookRepository.findByNameContainingIgnoreCase(searchQuery);
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam("bookName") String bookName) {
        Book book = new Book();
        book.setName(bookName);
        bookRepository.save(book);
        return "redirect:/books";
    }
}

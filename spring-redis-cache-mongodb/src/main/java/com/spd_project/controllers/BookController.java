package com.spd_project.controllers;

import com.spd_project.model.Book;
import com.spd_project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    public void save(@RequestBody Book book){
        bookService.save(book);
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/books/{isbn}")
    public Book findByIsbn(@PathVariable long isbn){
        return bookService.findByIsbn(isbn).get();
    }

    @DeleteMapping("/books/{isbn}")
    public void deleteByIsbn(@PathVariable long isbn){
        bookService.deleteByIsbn(isbn);
    }

    @PutMapping("books")
    public void update(@RequestBody Book book){
        bookService.save(book);
    }


}

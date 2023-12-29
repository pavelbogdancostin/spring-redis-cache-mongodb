package com.spd_project.controllers;

import com.spd_project.model.Book;
import com.spd_project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Cacheable(value = "cacheBook")
    @PostMapping("/addBook")
    public void save(@RequestBody Book book){
        System.out.println("Add book in Database");
        bookService.save(book);
    }

    @Cacheable(cacheNames = "books")
    @GetMapping("/findAllBooks")
    public List<Book> findAll(){
        System.out.println("Searching in Database");
        return bookService.findAll();
    }

    @Cacheable(cacheNames = "books", key = "#isbn")
    @GetMapping("/findBook/{isbn}")
    public Book findByIsbn(@RequestParam long isbn){
        System.out.println("Searching Book in Database");
        return bookService.findByIsbn(isbn).get();
    }

    @CacheEvict(cacheNames = "books", key = "#isbn")
    @DeleteMapping("/delete/{isbn}")
    public void deleteByIsbn(@PathVariable long isbn){
        System.out.println("book remove!");
        bookService.deleteByIsbn(isbn);
    }

    @CachePut(cacheNames = "books", key = "#book.isbn")
    @PutMapping("books")
    public void update(@RequestBody Book book){
        System.out.println("update book!");
        bookService.save(book);
    }


}

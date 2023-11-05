package com.spd_project.service;

import com.spd_project.model.Book;
import com.spd_project.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void save (Book book){
        bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findByIsbn(long isbn){
        return bookRepository.findById(isbn);
    }

    public void deleteByIsbn(long isbn){
        bookRepository.deleteById(isbn);
    }
}

package com.spd_project.repository;

import com.spd_project.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository <Book, Long>{
}


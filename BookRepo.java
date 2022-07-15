package com.SpringdataEnvers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.SpringdataEnvers.model.Book;
@Repository
public interface BookRepo extends RevisionRepository<Book,Long,Long> ,JpaRepository<Book, Long>{

}

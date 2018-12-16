package com.cts.ba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.ba.model.Book;

@Repository
public interface BookDAO extends CrudRepository<Book,Long>{

	@Query(value="SELECT b FROM Book b where b.title = :title")
    public List<Book> findByTitle(@Param("title") String title);

}

package com.cts.ba.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.ba.model.Book;
import com.cts.ba.model.Subject;
import com.cts.ba.repository.BookDAO;
import com.cts.ba.repository.SubjectDAO;

@Component
public class CrudUtilService {	
	
	@Autowired
	private SubjectDAO subjectDAOImpl;
	
	@Autowired
	private BookDAO bookDao;
	
	public  void addSubject(Subject subject) {
		subjectDAOImpl.save(subject);
	}
	
	public  Optional<Subject> getSubject(long subjectId) {
		return subjectDAOImpl.findById(subjectId);		
	}
	
	
	public Iterable<Subject> getAllSubjects() {
		return subjectDAOImpl.findAll();		
	}
	
	
	public void updateSubject(Subject subject) {
		subjectDAOImpl.save(subject);		
	}
	
	public  String deleteSubject(long subjectId) {
		subjectDAOImpl.deleteById(subjectId);
		return "The subject has been deleted";
	}
	//Book
	public  void addBook(Book book) {
		bookDao.save(book);
	}
	
	public  Optional<Book> getBook(long bookId) {
		return bookDao.findById(bookId);		
	}
	
	
	public Iterable<Book> getAllBooks() {
		return bookDao.findAll();		
	}
	
	
	public List<Book> findBySubjectTitle(String title) {
		return bookDao.findByTitle(title);		
	}
	
	public List<Subject> findByDurationInHours(int durationInHours) {
		return subjectDAOImpl.findByDurationInHours(durationInHours);		
	}
	
	public void updateBook(Book book) {
		bookDao.save(book);		
	}
	
	public  String deleteBook(long id) {
		bookDao.deleteById(id);
		return "The Book has been deleted";
	}
	
}

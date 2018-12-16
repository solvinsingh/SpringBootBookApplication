package com.cts.ba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ba.model.Book;
import com.cts.ba.service.CrudUtilService;



/**
 * Handles requests for the Book management.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	CrudUtilService bookService;

	@ModelAttribute("book")
	public Book creatBookModel() {
		return new Book();
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showAddForm() {
		return new ModelAndView("addBook");
	}

	@RequestMapping(value = "/book",method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult) {
				
			bookService.addBook(book);
	
		System.out.println("addBook() =>"+book);

		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showEditForm(@PathVariable String id) {

		Optional<Book> book;
		
			book = bookService.getBook(Long.valueOf(id));

		return new ModelAndView("updateBook", "book", book);
	}
	
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showSearchBookForm() {
		return new ModelAndView("searchBook", "book", new Book());

	}

	@RequestMapping(value = "/searchBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public ModelAndView searchBook(@ModelAttribute("book") Book book, BindingResult bindingResult) {
		
		List<Book> listOfBooks = bookService.findBySubjectTitle(book.getTitle());
		System.out.println("addBook() =>"+book);

		return new ModelAndView("searchBook", "listOfBooks", listOfBooks);
	}
		

	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public String updateBook(@ModelAttribute Book book, BindingResult bindingResult) {
	
		
			bookService.updateBook(book);

		return "redirect:/book/list"; 
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteBook(@PathVariable String id) {
        System.out.println("inside deleteBook() for id="+id);
        String status=bookService.deleteBook(Long.valueOf(id));
        return "redirect:/book/list"; 
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView listBooks() {

		Iterable<Book> bookList;
	
			bookList = bookService.getAllBooks();

		ModelAndView modelView = new ModelAndView("listBooks", "bookList", bookList);
		modelView.addObject("userName","Admin"); 
		return modelView;
	}

}

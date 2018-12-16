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

import com.cts.ba.model.Subject;
import com.cts.ba.service.CrudUtilService;


/**
 * Handles requests for the subject management.
 */
@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

	@Autowired
	CrudUtilService bookService;

	@ModelAttribute("subject")
	public Subject creatSubjectModel() {
		return new Subject();
	}

	
	@RequestMapping(value = "/addSubject", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showAddForm() {
		return new ModelAndView("addSubject");
	}

	@RequestMapping(value = "/subject",method = RequestMethod.POST, headers = "Accept=application/json")
	public String addSubject(@ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
		bookService.addSubject(subject);

		return "redirect:/subject/list";
	}

	@RequestMapping(value = "/searchSubject", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showSearchBookForm() {
		return new ModelAndView("searchSubject", "subject", new Subject());

	}

	@RequestMapping(value = "/searchSubject", method = RequestMethod.POST, headers = "Accept=application/json")
	public ModelAndView searchBook(@ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
		
		List<Subject> listOfSubjects = bookService.findByDurationInHours(subject.getDurationInHours());
		return new ModelAndView("searchSubject", "listOfSubjects", listOfSubjects);
	}	

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView showEditForm(@PathVariable String id) {

		Optional<Subject> subject = bookService.getSubject(Long.valueOf(id));
		return new ModelAndView("updateSubject", "subject", subject);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public String updateSubject(@ModelAttribute Subject subject, BindingResult bindingResult) {
	
		
		bookService.updateSubject(subject);
		
		return "redirect:/subject/list"; 
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteSubject(@PathVariable String id) {
        System.out.println("inside deleteSubect for id="+id);
        bookService.deleteSubject(Integer.valueOf(id));
        return "redirect:/subject/list"; 
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView listEmployees() {

		Iterable<Subject> subList = bookService.getAllSubjects();
		ModelAndView modelView = new ModelAndView("listSubjects", "subList", subList);
		modelView.addObject("userName","Admin"); 
		return modelView;
	}

}

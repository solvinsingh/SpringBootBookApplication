package com.cts.ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ba.model.Login;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(Model model, @ModelAttribute("loginBean") Login loginBean) {
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			if (loginBean.getUserName().equals("librarian") && loginBean.getPassword().equals("pass123")) {
				ModelAndView modelView = new ModelAndView("home");
				modelView.addObject("role", loginBean.getUserName());
				return modelView;
			}
			if (loginBean.getUserName().equals("principal") && loginBean.getPassword().equals("pass123")) {
				ModelAndView modelView = new ModelAndView("home");
				modelView.addObject("role", loginBean.getUserName());
				return modelView;
			} else {
				model.addAttribute("error", "Invalid Details");
				return new ModelAndView("login");
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return new ModelAndView("login");
		}
	}
}
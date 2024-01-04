package com.tableslearnedmapping.entitymapping.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.tableslearnedmapping.entitymapping.entities.User;
import com.tableslearnedmapping.entitymapping.repo.Userrepo;
import com.tableslearnedmapping.entitymapping.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private Userrepo userRepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m,HttpServletRequest request) {
		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}
		String currentUrl = request.getRequestURI();
	    m.addAttribute("currentUrl", currentUrl);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user",new User());
		return "register";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}


	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute User user,BindingResult br, HttpSession session, Model m) {
try {
if(br.hasErrors())
{
	m.addAttribute("user",user);
	System.out.println(br);
	return "redirect:/register";
}
		User u = userService.saveUser(user);

		if (u != null) {
		
			session.setAttribute("msg", "Register successfully");

		}
		return "redirect:/register";
}
catch(Exception ex)
{
	ex.printStackTrace();
	m.addAttribute("user", user);
	session.setAttribute("msg", "Something wrong");
		return "redirect:/register";
}
	}

}
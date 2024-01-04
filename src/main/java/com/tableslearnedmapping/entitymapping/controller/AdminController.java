package com.tableslearnedmapping.entitymapping.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tableslearnedmapping.entitymapping.entities.User;
import com.tableslearnedmapping.entitymapping.repo.Userrepo;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private Userrepo userRepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}
	}

	@GetMapping("/profile")
	public String profile() {
		return "admin_profile";
	}
}

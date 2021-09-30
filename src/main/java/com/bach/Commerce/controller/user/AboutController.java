package com.bach.Commerce.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bach.Commerce.service.LoginService;
import com.bach.Commerce.service.UserService;

@Controller
public class AboutController {
	
	@Autowired
	UserService userService;

	
	@GetMapping("/about")
	public String aboutUs(Model model) {
		
		try {
			LoginService principal = (LoginService) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("id", principal.getId());
			model.addAttribute("user", userService.getUserById(principal.getId()));
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return "about";
	}
}

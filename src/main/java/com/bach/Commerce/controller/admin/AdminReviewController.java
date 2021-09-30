package com.bach.Commerce.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bach.Commerce.service.ReviewService;

@Controller
public class AdminReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/admin/review")
	public String getComment(Model model) {
		
		model.addAttribute("reviews", reviewService.getAllReview());
		
		return "/admin/viewReview";
	}
	
	@GetMapping("/admin/review/delete/{id}")
	public String deleteReview(@PathVariable(name = "id")int id) {
		
		reviewService.delete(id);
		
		return "redirect:/admin/review";
	}	
}

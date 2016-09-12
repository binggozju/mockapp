package org.binggo.mockapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.binggo.mockapp.domain.City;

@Controller
public class WebUIController {
	
	@GetMapping("/")
	public String cityForm(Model model) {
		model.addAttribute("city", new City());
		return "form";
	}
	
	@PostMapping("/")
	public String cityResponse(@ModelAttribute City city) {
		return "response";
	}

}

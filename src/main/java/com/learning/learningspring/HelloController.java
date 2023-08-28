package com.learning.learningspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String index(@RequestParam(name="name", defaultValue = "world", required=false) String name, Model model) {
		model.addAttribute("name", name);
		return "greetings";
	}
}

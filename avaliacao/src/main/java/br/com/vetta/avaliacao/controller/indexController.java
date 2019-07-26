package br.com.vetta.avaliacao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
	@Value("${spring.application.name}")
    String appName;
	
	@GetMapping({"/"})
	public String hello(Model model) {
		model.addAttribute("name", appName);
		return "index";
	}	

}

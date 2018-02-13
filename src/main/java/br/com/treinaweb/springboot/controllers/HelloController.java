package br.com.treinaweb.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Karen
 * 13 de fev de 2018
 */
@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("mensagem", "Olá Spring Boot com thymeleaf.");
		return "index";
	}
}

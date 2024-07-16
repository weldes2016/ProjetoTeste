package com.projetoteste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud")
public class HomeController {

	@GetMapping("/crud")
	public String showCrudPage() {
		return "crud.xhtml";
	}
}

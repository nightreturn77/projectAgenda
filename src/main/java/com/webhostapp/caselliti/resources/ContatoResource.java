package com.webhostapp.caselliti.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.webhostapp.caselliti.services.ContatoService;

@Controller
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping	("/")
	public String root() { 
		return "/index";
	}
	
	
	
	
}

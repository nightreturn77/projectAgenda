package com.webhostapp.caselliti.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.webhostapp.caselliti.entity.Contato;
import com.webhostapp.caselliti.services.ContatoService;

@Controller
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	
	//abre a página principal da aplicação
	@GetMapping	("/")
	public String root(@Valid Contato contato, BindingResult result, Model model) { 
		model.addAttribute("contatos", service.findAll()); //serve para fazer o foreach do thymeleaf funcionar
		return "/index";
	}
	
	//abre o cadastro
	@GetMapping("/signup")
	public String signup(Contato contato) { 
		return "add-user";
	}
	
	
	//se colocar na url localhost:8080/json abrirá todo o cadastro em json
	@GetMapping("/json")
	public ResponseEntity<List<Contato>> procurar(){ 
		List<Contato> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	//CRUD = insert, cadastra nosso objeto
	@PostMapping("/addcontato")
	public String insert(@Valid Contato obj, BindingResult result, Model model){ 
		obj = service.insert(obj);
		model.addAttribute("contatos", service.findAll()); //serve para fazer o foreach do thymeleaf funcionar
		return "/index";
		
	}
	
	//Procura no json por id na url
	@GetMapping(value = "/json/{id}")
	public ResponseEntity<Contato> procurarId(@PathVariable Long id){ 
		Contato cont = service.findById(id);
		return ResponseEntity.ok().body(cont);
	}
	
	
	//Deleta json baseado no id
	@DeleteMapping(value = "/json/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
}

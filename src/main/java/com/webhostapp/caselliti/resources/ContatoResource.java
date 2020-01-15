package com.webhostapp.caselliti.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webhostapp.caselliti.entity.Contato;
import com.webhostapp.caselliti.services.ContatoService;

@Controller
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	
	//abre a página principal da aplicação
	@GetMapping	("/")
	public String root() { 
		return "/index";
	}
	
	
	//se colocar na url localhost:8080/json abrirá todo o cadastro em json
	@GetMapping("/json")
	public ResponseEntity<List<Contato>> procurar(){ 
		List<Contato> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	//CRUD = insert, cadastra nosso objeto
	@PostMapping
	public ResponseEntity<Contato> insert(@RequestBody Contato obj){ 
		obj = service.insert(obj);
		//Utilizei dessa forma pois é mais adequado, evitando o código 200 (que não é ruim), porém 201 é mais adequado
		//virifiquei esse código utilizando o POSTMAN (200/201)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@GetMapping(value = "/json/{id}")
	public ResponseEntity<Contato> procurarId(@PathVariable Long id){ 
		Contato cont = service.findById(id);
		return ResponseEntity.ok().body(cont);
	}
	
	@DeleteMapping(value = "/json/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
}

package com.webhostapp.caselliti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webhostapp.caselliti.entity.Contato;
import com.webhostapp.caselliti.repositories.ContatoRepository;




@Service
public class ContatoService {


	@Autowired
	private ContatoRepository repository;
	
	
	
	public List<Contato> findAll(){ 
		return repository.findAll();
	}

	public Contato findById(Long id) { 
		Optional<Contato> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Contato insert(Contato obj) { 
		return repository.save(obj);
	}
	
	
	public void delete(Long id) { 
		repository.deleteById(id);
	}
	
	public Contato update(Long id, Contato obj) {
		
			Contato entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
			
	}

	private void updateData(Contato entity, Contato obj) {
		entity.setNome(obj.getNome());
		entity.setTel(obj.getTel());
		entity.setEmail(obj.getEmail());
	}
}

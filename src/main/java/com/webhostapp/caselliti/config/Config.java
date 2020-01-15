package com.webhostapp.caselliti.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webhostapp.caselliti.entity.Contato;
import com.webhostapp.caselliti.repositories.ContatoRepository;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

	@Autowired
	private ContatoRepository contatoRepository;
	


	@Override
	public void run(String... args) throws Exception {
		Contato cont = new Contato(null, "Victor", 989859785, "Calepi", "Victor@dias");
	
		contatoRepository.saveAll(Arrays.asList(cont));
		System.out.println(cont);
		//userRepository.saveAll(Arrays.asList(u1,u2));
		//orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	

}

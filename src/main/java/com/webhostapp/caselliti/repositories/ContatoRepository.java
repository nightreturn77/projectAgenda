package com.webhostapp.caselliti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webhostapp.caselliti.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

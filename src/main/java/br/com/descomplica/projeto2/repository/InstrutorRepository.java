package br.com.descomplica.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.descomplica.projeto2.entity.Instrutor;

public interface InstrutorRepository extends JpaRepository<Instrutor,Integer> {

}
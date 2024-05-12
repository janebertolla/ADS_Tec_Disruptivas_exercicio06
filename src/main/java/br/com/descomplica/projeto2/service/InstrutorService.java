package br.com.descomplica.projeto2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.descomplica.projeto2.entity.Instrutor;
import br.com.descomplica.projeto2.repository.InstrutorRepository;

@Service
public class InstrutorService {
	@Autowired
	InstrutorRepository instrutorRepository;
	
	public List<Instrutor> getAll(){
		return instrutorRepository.findAll();
	}
	
	public Instrutor getById(Integer id) {
		return instrutorRepository.findById(id).orElse(null) ;
	}
	
	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public Instrutor updateInstrutor(Integer id, Instrutor instrutor) {
		Instrutor instrutorAlvo = instrutorRepository.findById(id).orElse(null);
		if(instrutorAlvo != null) {
			instrutorAlvo.setNome(instrutor.getNome());

			instrutorAlvo.setRG(instrutor.getRG());

			instrutorAlvo.setNascimento(instrutor.getNascimento());

			instrutorAlvo.setTitulacao(instrutor.getTitulacao());


			return instrutorRepository.save(instrutorAlvo);
		}else {
			return null;
		}
	}

	public Boolean deleteInstrutor(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).orElse(null);
		if(instrutor != null) {
			instrutorRepository.delete(instrutor);
			return true;
		}else {
			return false;
		}
	}
}
package br.com.descomplica.projeto2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.descomplica.projeto2.entity.Turma;
import br.com.descomplica.projeto2.repository.TurmaRepository;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> getAll(){
        return turmaRepository.findAll();
    }

    public Turma getById(Integer id){
        return turmaRepository.findById(id).orElse(null);
    }

    public Turma saveTurma( Turma turma){
        return turmaRepository.save(turma);
    }

    public Turma updateTurma(Integer id, Turma turma){
        Turma turmaAlvo = turmaRepository.findById(id).orElse(null);
        if (turmaAlvo != null){
            
            turmaAlvo.setHorario(turma.getHorario());

            turmaAlvo.setDataInicio(turma.getDataInicio());

            turmaAlvo.setDataFim(turma.getDataFim());

            return turmaRepository.save(turmaAlvo); 
        } else{
            return null;
        }
    }

    public Boolean deleteTurma( Integer id){
        Turma turma = turmaRepository.findById(id).orElse(null);
        if( turma != null){
            turmaRepository.delete(turma);
            return true;
        }else {
            return false;
        }
    }

}

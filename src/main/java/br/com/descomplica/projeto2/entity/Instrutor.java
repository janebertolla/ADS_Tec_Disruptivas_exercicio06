package br.com.descomplica.projeto2.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "instrutor")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinstrutor")
    private Integer idinstrutor;

    @Column(name = "RG")
    private Integer RG;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nascimento")
    private Date nascimento;

    @Column(name = "titulacao")
    private Integer titulacao;

    @OneToMany(mappedBy = "instrutor")
    @JsonManagedReference
    private List<Turma> turmas;

    public Integer getIdinstrutor() {
        return idinstrutor;
    }

    public void setIdinstrutor(Integer idinstrutor) {
        this.idinstrutor = idinstrutor;
    }

    public Integer getRG() {
        return RG;
    }

    public void setRG(Integer RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Integer titulacao) {
        this.titulacao = titulacao;
    }

    public List<Turma> getTurmas(){
        return turmas;
    }

    public void setTurmas(List<Turma> turmas){
        this.turmas = turmas;
    }
}

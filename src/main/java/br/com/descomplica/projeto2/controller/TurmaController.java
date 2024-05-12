package br.com.descomplica.projeto2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.descomplica.projeto2.entity.Turma;
import br.com.descomplica.projeto2.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired 
    TurmaService turmaService;

    @PostMapping
    @Operation(summary="Criar nova Turma", description  = "Cria nova turma com os valores passados no corpo da requisição")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Turma> saveTurma (@RequestBody Turma turma) {
        return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary="Listar todas as turmas", description  = "Obtém todas as turmas já registradas")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<List<Turma>> getAll(){
        List<Turma> turmas = turmaService.getAll();
        if (!turmas.isEmpty()){
            return new ResponseEntity<>(turmas, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary="Obter turma pelo id fornecido", description  = "Retorna o registro da turma cujo id corresponde ao valor informado")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Turma> getById(@PathVariable Integer id) {
        Turma turma = turmaService.getById(id);
        if (turma != null) {
            return new ResponseEntity<>(turma, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{ìd}")
    @Operation(summary="Atualizar turma", description  = "Atualiza o registro da turma cujo id corresponde ao valor informado com os valores informados no corpo da requisição")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Turma> updateTurma(@PathVariable Integer id, @RequestBody Turma turma) {
        Turma turmaAtualizada = turmaService.updateTurma(id, turma);
        if (turmaAtualizada != null) {
            return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Deletar turma", description  = "Deleta o registro da turma cujo id corresponde ao valor informado")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Boolean> deleteTurma(@PathVariable Integer id) {
        if (turmaService.deleteTurma(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}

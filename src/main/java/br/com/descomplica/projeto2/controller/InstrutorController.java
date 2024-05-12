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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import br.com.descomplica.projeto2.entity.Instrutor;
import br.com.descomplica.projeto2.service.InstrutorService;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
    @Autowired
    InstrutorService instrutorService;

    @GetMapping
	@Operation(summary="Listar todos os instrutores", description  = "Listagem de instrutores")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	public ResponseEntity<List<Instrutor>> getAll() {
        List<Instrutor> instrutores = instrutorService.getAll();
        if (!instrutores.isEmpty()) {
            return new ResponseEntity<>(instrutores, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary="Obter instrutor cujo id corresponde ao valor fornecido", description  = "Obter Instrutor por id")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Instrutor> getById(@PathVariable Integer id) {
        Instrutor instrutor = instrutorService.getById(id);
        if (instrutor != null) {
            return new ResponseEntity<>(instrutor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary="Criar novo instrutor", description  = "Cria um novo instrutor a partir dos parâmetros fornecidos no corpo da requisição")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Instrutor> saveInstrutor(@RequestBody Instrutor instrutor) {
        return new ResponseEntity<>(instrutorService.saveInstrutor(instrutor), HttpStatus.CREATED);
        }
    
    @DeleteMapping("/{id}")
    @Operation(summary="Deletar instrutor", description  = "Deleta o instrutor cujo id corresponde ao valor fornecido")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Boolean> deleteInstrutor(@PathVariable Integer id) {
        if(instrutorService.deleteInstrutor(id)) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary="Atualizar instrutor", description  = "Atualiza (edita) instrutor  cujo id corresponde ao valor fornecido com os atributos passados no corpo da requisição")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Instrutor> updateInstrutor(@PathVariable Integer id, @RequestBody Instrutor instrutor){
        Instrutor instrutorAlvo = instrutorService.updateInstrutor(id, instrutor);
        if (instrutorAlvo != null) {
            return new ResponseEntity<>(instrutorAlvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



}

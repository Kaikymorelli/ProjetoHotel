package com.ProjetoHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoHotel.entities.Quartos;
import com.ProjetoHotel.service.QuartosService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/quartos")
public class QuartosController {
	private final QuartosService quartossService;

	@Autowired
	public QuartosController(QuartosService quartossService) {
		this.quartossService = quartossService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quartos> buscaQuartosControlId(@PathVariable Long id){
		Quartos quartoss  = quartossService.buscaQuartosId(id);
		if(quartoss != null) {
			return ResponseEntity.ok(quartoss);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Quartos>> buscaTodosQuartossControl(){
		List<Quartos> quartosss = quartossService.buscaTodosQuartos();
		return ResponseEntity.ok(quartosss);
	}

	@PostMapping
	public ResponseEntity<Quartos> salvaQuartossControl(@RequestBody @Valid Quartos quartoss){
		Quartos salvaQuartos = quartossService.salvaQuartos(quartoss);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaQuartos);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Quartos> alteraQuartosControl(@PathVariable Long id, @RequestBody @Valid Quartos quartoss){
		Quartos alteraQuartos = quartossService.alterarQuartos(id, quartoss);
		if(alteraQuartos != null) {
			return ResponseEntity.ok(quartoss);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaQuartosControl(@PathVariable Long id){
		boolean apagar = quartossService.apagarQuartos(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Quartos foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}


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

import com.ProjetoHotel.entities.Hospedes;
import com.ProjetoHotel.service.HospedesService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("hospedes")
public class HospedesController {
	private final HospedesService hospedesService;

	@Autowired
	public HospedesController(HospedesService hospedesService) {
		this.hospedesService = hospedesService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospedes> buscaHospedesControlId(@PathVariable Long id){
		Hospedes hospedes  = hospedesService.buscaHospedesId(id);
		if(hospedes != null) {
			return ResponseEntity.ok(hospedes);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Hospedes>> buscaTodosHospedessControl(){
		List<Hospedes> hospedess = hospedesService.buscaTodosHospedes();
		return ResponseEntity.ok(hospedess);
	}

	@PostMapping
	public ResponseEntity<Hospedes> salvaHospedessControl(@RequestBody @Valid Hospedes hospedes){
		Hospedes salvaHospedes = hospedesService.salvaHospedes(hospedes);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaHospedes);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hospedes> alteraHospedesControl(@PathVariable Long id, @RequestBody @Valid Hospedes hospedes){
		Hospedes alteraHospedes = hospedesService.alterarHospedes(id, hospedes);
		if(alteraHospedes != null) {
			return ResponseEntity.ok(hospedes);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaHospedesControl(@PathVariable Long id){
		boolean apagar = hospedesService.apagarHospedes(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Hospedes foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
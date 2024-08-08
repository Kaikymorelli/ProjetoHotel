package com.ProjetoHotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoHotel.entities.Quartos;
import com.ProjetoHotel.repository.QuartosRepository;

@Service
public class QuartosService {

	private final QuartosRepository quartosRepository;

	@Autowired
	public QuartosService(QuartosRepository quartosRepository) {
		this.quartosRepository = quartosRepository;
	}
	public List<Quartos> buscaTodosQuartos(){
		return quartosRepository.findAll();
	}
	public Quartos buscaQuartosId(Long id) {
		Optional <Quartos> existeQuartos = quartosRepository.findById(id);
		return existeQuartos.orElse(null);
	}
	public Quartos salvaQuartos(Quartos Quartos) {
		return quartosRepository.save(Quartos);		
	}
	public Quartos alterarQuartos(Long id, Quartos alterarQuartos) {
		Optional <Quartos> existeQuartos = quartosRepository.findById(id);
		if (existeQuartos.isPresent()) {
			alterarQuartos.setId(id);;
			return quartosRepository.save(alterarQuartos);
		}
		return null;
	}
	public boolean apagarQuartos(Long id) {
		Optional <Quartos> existeQuartos = quartosRepository.findById(id);
		if (existeQuartos.isPresent()) {
			quartosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

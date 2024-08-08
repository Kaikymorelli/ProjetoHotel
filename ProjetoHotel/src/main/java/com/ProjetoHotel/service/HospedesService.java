package com.ProjetoHotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoHotel.entities.Hospedes;
import com.ProjetoHotel.repository.HospedesRepository;

@Service
public class HospedesService {

	private final HospedesRepository hospedesRepository;

	@Autowired
	public HospedesService(HospedesRepository hospedesRepository) {
		this.hospedesRepository = hospedesRepository;
	}
	public List<Hospedes> buscaTodosHospedes(){
		return hospedesRepository.findAll();
	}
	public Hospedes buscaHospedesId(Long id) {
		Optional <Hospedes> existeHospedes = hospedesRepository.findById(id);
		return existeHospedes.orElse(null);
	}
	public Hospedes salvaHospedes(Hospedes hospedes) {
		return hospedesRepository.save(hospedes);		
	}
	public Hospedes alterarHospedes(Long id, Hospedes alterarHospedes) {
		Optional <Hospedes> existeHospedes = hospedesRepository.findById(id);
		if (existeHospedes.isPresent()) {
			alterarHospedes.setId(id);;
			return hospedesRepository.save(alterarHospedes);
		}
		return null;
	}
	public boolean apagarHospedes(Long id) {
		Optional <Hospedes> existeHospedes = hospedesRepository.findById(id);
		if (existeHospedes.isPresent()) {
			hospedesRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

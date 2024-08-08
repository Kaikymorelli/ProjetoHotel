package com.ProjetoHotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservas")
public class Reserva {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(name = "numeroDeQuarto")
	private String numeroDeQuarto;
	
	@NotNull
	@NotBlank
	@Column(name = "telefone")
	private String telefone;
	
	@NotNull
	@NotBlank
	@Column(name = "cpf")
	private String cpf;
	
	@NotNull
	@NotBlank
	@Column(name = "qtdePessoas")
	private String qtdePessoas;
	
	@NotNull
	@NotBlank
	@Column(name = "DataDeEntrada")
	private String DataDeEntrada;
	
	@NotNull
	@NotBlank
	@Column(name = "DataDeSaida")
	private String DataDeSaida;
	
	@ManyToOne
	@JoinColumn(name = "id_hospedes")
	private Hospedes hospedes;
	
	@ManyToOne
	@JoinColumn(name = "id_quartos")
	private Quartos quartos;
	
}



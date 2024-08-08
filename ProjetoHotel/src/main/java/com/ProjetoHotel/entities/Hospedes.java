package com.ProjetoHotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "hospedes")
public class Hospedes {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(name = "nome")
	private String nome;
	
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
	@Column(name = "endereco")
	private String endereco;
	
	@NotNull
	@NotBlank
	@Column(name = "email")
	private String email;
	

}

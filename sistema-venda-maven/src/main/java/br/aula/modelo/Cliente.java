package br.aula.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Fernando
 */
@Entity
public class Cliente implements Serializable {
	
	public Cliente() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String rg;
	private String cpf;

	public Cliente(String nome, String rg, String cpf) {

		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

}

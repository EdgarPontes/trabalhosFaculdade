package br.com.tecnonoticias.modelo.agenda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class AgendaTelefonica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	private String nome;
	private String telefone;
	private Date dataRegistro;
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
}
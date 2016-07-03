package br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo;

public class Pessoa {
	
	private long pessoaId;
	private String endereco;
	private String cidade;
	private String estado;
	
	public long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(long pessoaId) {
		this.pessoaId = pessoaId;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}	
}
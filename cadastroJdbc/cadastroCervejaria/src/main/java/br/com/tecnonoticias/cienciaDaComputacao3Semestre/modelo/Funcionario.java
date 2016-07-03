package br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo;

public class Funcionario extends PessoaFisica{
	
	private long funcionarioId;
	private String usuario;
	private String senha;
	
	public long getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
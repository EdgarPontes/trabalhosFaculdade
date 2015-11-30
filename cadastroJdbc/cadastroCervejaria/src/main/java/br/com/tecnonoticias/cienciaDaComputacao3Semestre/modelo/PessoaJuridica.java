package br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo;

public class PessoaJuridica extends Pessoa{
	
	private long fornecedorId;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public long getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(long fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

}

package br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao;

import java.util.List;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaFisica;

public interface Dao {

	void adiciona(PessoaFisica contato);
	
	public List<PessoaFisica> busca();
	
	void altera(PessoaFisica contato);
	
	void deleta(PessoaFisica contato);
	
	void buscaId();
}

package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.PessoaDao;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaFisica;

public class JdbcTesteDeleta {

	public static void main(String[] args) {
		
		PessoaDao dao = new PessoaDao();
		
		PessoaFisica contato = new PessoaFisica();
		
		contato.setPessoaId(1l);
		
		dao.deleta(contato);
		
		System.out.println("Exclusão efetuada com sucesso! ");
	}
}
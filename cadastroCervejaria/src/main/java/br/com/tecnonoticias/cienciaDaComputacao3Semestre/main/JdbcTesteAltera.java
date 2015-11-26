package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.util.Calendar;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.PessoaDao;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaFisica;

public class JdbcTesteAltera {

	public static void main(String[] args) {

		PessoaDao dao = new PessoaDao();

		// pronto para gravar
		PessoaFisica contato = new PessoaFisica();

		contato.setNome("Edgar");
		contato.setCpf("029.022.099-98");
		contato.setEndereco("R. Nove, 47");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setPessoaId(1L);

		// grave nessa conexão!!!
		dao.altera(contato);

		System.out.println("Alterado!");
	}
}
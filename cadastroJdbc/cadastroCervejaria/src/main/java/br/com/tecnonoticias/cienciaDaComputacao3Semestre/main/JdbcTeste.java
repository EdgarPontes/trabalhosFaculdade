package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.PessoaDao;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaFisica;

public class JdbcTeste {

	public static void main(String[] args) throws SQLException {
		Clientes tela = new Clientes();
		// pronto para gravar
		 PessoaFisica contato = new PessoaFisica();

//		 contato.setNome(tela.tf_Nome.getText());
//		 contato.setCpf(tela.tf_Cpf.getText());
//		 contato.setRg(tela.tf_Rg.getText());
//		 contato.setEndereco(tela.tf_Endereço.getText());
//		 contato.setCidade(tela.tf_Cidade.getText());
//		 contato.setEstado(tela.tf_Estado.getText());
//		 contato.setSexo(tela.tf_Sexo.getText());
//		 contato.setDataNascimento(Calendar.getInstance());

		 // grave nessa conexão!!!
		 PessoaDao dao = new PessoaDao();

		 // método elegante
		 dao.adiciona(contato);

		 System.out.println("Gravado!");
		
//		Connection connection = new ConnectionFactory().getConnection();
//		System.out.println("Conexão aberta!");
//		connection.close();
	}
}
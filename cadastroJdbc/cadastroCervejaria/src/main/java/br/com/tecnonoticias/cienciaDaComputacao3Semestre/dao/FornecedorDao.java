
package br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.ConnectionFactory;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaJuridica;

public class FornecedorDao {

	/**
	 * Conexão com o banco de dados
	 */
	private Connection connection;

	public FornecedorDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/**
	 * Inclui os dados no BD
	 */
	public void adiciona(PessoaJuridica contato) {

		String sql = "insert into Fornecedor " + "(razaoSocial, nomeFantazia, cnpj, endereco, cidade, estado)" + " values (?,?,?,?,?,?)";
		try {
			/**
			 * Prepara o statement para inserção
			 */
			PreparedStatement stmt = connection.prepareStatement(sql);

			/**
			 * Seta os valores
			 */
			stmt.setString(1, contato.getRazaoSocial());
			stmt.setString(2, contato.getNomeFantasia());
			stmt.setString(3, contato.getCnpj());
			stmt.setString(4, contato.getEndereco());
			stmt.setString(5, contato.getCidade());
			stmt.setString(6, contato.getEstado());
			// stmt.setDate(8, new
			// Date(contato.getDataNascimento().getTimeInMillis()));

			/**
			 * Executa a operação
			 */
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Busca os dados no BD
	 */
	public List<PessoaJuridica> busca() {
		try {
			List<PessoaJuridica> contatos = new ArrayList<PessoaJuridica>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from Fornecedor");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				/**
				 * Criando o objeto
				 */
				PessoaJuridica contato = new PessoaJuridica();

				contato.setFornecedorId(rs.getLong("fornecedorId"));
				contato.setRazaoSocial(rs.getString("razaoSocial"));
				contato.setNomeFantasia(rs.getString("nomeFantazia"));
				contato.setCnpj(rs.getString("cnpj"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setCidade(rs.getString("cidade"));
				contato.setEstado(rs.getString("estado"));

				/**
				 * Montando a data através do Calendar
				 */
				// Calendar data = Calendar.getInstance();
				// data.setTime(rs.getDate("dataNascimento"));
				// contato.setDataNascimento(data);

				/**
				 * Adicionando o objeto à lista
				 */
				contatos.add(contato);
			}
			/**
			 * Fecha a conexão com BD
			 */
			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Altera os dados no BD
	 */
	public void altera(PessoaJuridica contato) {

		String sql = "update Fornecedor set razaoSocial=?, nomeFantazia=?, cnpj=?, endereco=?, cidade=?, estado=? where fornecedorId=?";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getRazaoSocial());
			stmt.setString(2, contato.getNomeFantasia());
			stmt.setString(3, contato.getCnpj());
			stmt.setString(4, contato.getEndereco());
			stmt.setString(5, contato.getCidade());
			stmt.setString(6, contato.getEstado());
			stmt.setLong(7, contato.getFornecedorId());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Deleta os dados no BD
	 */
	public void deleta(PessoaJuridica contato) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from Fornecedor where fornecedorid=?");
			stmt.setLong(1, contato.getFornecedorId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	public void buscaId() {
		try {
			String sql = "SELECT MAX(fornecedorId) as fornecedorId FROM fornecedor";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int ultimoId = rs.getInt("pessoaId");

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
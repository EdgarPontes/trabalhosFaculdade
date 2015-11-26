package br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.ConnectionFactory;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.Usuario;

public class UsuarioDao {

	/**
	 * Conexão com o banco de dados
	 */
	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {
		String sql = "insert into Usuario " + "(usuario, senha)" + " values (?,?)";
		try {
			/**
			 * Prepara o statement para inserção
			 */
			PreparedStatement stmt = connection.prepareStatement(sql);

			/**
			 * Seta os valores
			 */
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());

			/**
			 * Executa a operação
			 */
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Usuario> busca() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from Usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				/**
				 * Criando o objeto
				 */
				Usuario usuario = new Usuario();

				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));

				/**
				 * Adicionando o objeto à lista
				 */
				usuarios.add(usuario);
			}
			/**
			 * Fecha a conexão com BD
			 */
			rs.close();
			stmt.close();
			return usuarios;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Usuario usuario) {
		String sql = "update Usuario set senha=?, where usuario=?";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getSenha());

			stmt.setString(2, usuario.getUsuario());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deleta(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from Usuario where usuario=?");
			stmt.setString(1, usuario.getUsuario());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean acessarSistema(Object user, Object pass) {
		try {
			// List<Usuario> usuarios = new ArrayList<Usuario>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from Usuario where" + user + "and" + pass);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Usuario usuario = new Usuario();

				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));

//				usuarios.add(usuario);
				if (user.equals(usuario.getUsuario()) && pass.equals(usuario.getSenha())) {
					return true;
				}
			}
			
			rs.close();
			stmt.close();
			return false;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void buscaId() {
		// TODO Auto-generated method stub

	}

}

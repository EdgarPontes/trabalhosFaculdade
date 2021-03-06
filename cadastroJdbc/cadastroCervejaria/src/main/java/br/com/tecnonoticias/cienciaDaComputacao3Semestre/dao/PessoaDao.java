package br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.ConnectionFactory;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaFisica;

public class PessoaDao {

	/**
	 * Conexão com o banco de dados
	 */
	private Connection connection;

	public PessoaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	/**
	 * Inclui os dados no BD
	 */
	public void adiciona(PessoaFisica contato) {

	     String sql = "insert into Pessoa " + "(nome,cpf,rg,sexo,endereco,cidade,estado)" + " values (?,?,?,?,?,?,?)";
	     try {
	        /**
	         * Prepara o statement para inserção 
	         */
	         PreparedStatement stmt = connection.prepareStatement(sql);

	         /**
	          * Seta os valores
	          */
	         stmt.setString(1,contato.getNome());
	         stmt.setString(2,contato.getCpf());
	         stmt.setString(3,contato.getRg());
	         stmt.setString(4,contato.getSexo());
	         stmt.setString(5,contato.getEndereco());
	         stmt.setString(6,contato.getCidade());
	         stmt.setString(7,contato.getEstado());
//	         stmt.setDate(8, new Date(contato.getDataNascimento().getTimeInMillis()));
	         
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
	public List<PessoaFisica> busca() {
	     try {
	         List<PessoaFisica> contatos = new ArrayList<PessoaFisica>();

	         PreparedStatement stmt = this.connection.
	         prepareStatement("select * from Pessoa");
	         ResultSet rs = stmt.executeQuery();

	         while (rs.next()) {
	             /**
	              * Criando o objeto
	              */
	             PessoaFisica contato = new PessoaFisica();
	             
	             contato.setPessoaId(rs.getLong("pessoaId"));
	             contato.setNome(rs.getString("nome"));
	             contato.setCpf(rs.getString("cpf"));
	             contato.setRg(rs.getString("rg"));
	             contato.setSexo(rs.getString("sexo"));
	             contato.setEndereco(rs.getString("endereco"));
	             contato.setCidade(rs.getString("cidade"));
	             contato.setEstado(rs.getString("estado"));

	             /**
	              * Montando a data através do Calendar
	              */
//	             Calendar data = Calendar.getInstance();
//	             data.setTime(rs.getDate("dataNascimento"));
//	             contato.setDataNascimento(data);

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
	public void altera(PessoaFisica contato) {

	     String sql = "update Pessoa set nome=?, cpf=?, rg=?, sexo=?, endereco=?, cidade=?, estado=? where pessoaId=?";
	     try {

	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setString(1,contato.getNome());
	         stmt.setString(2,contato.getCpf());
	         stmt.setString(3,contato.getRg());
	         stmt.setString(4,contato.getSexo());
	         stmt.setString(5,contato.getEndereco());
	         stmt.setString(6,contato.getCidade());
	         stmt.setString(7,contato.getEstado());
	         stmt.setLong(8, contato.getPessoaId());
	         stmt.executeUpdate();
	         stmt.close();

	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	/**
	 * Deleta os dados no BD 
	 */
	public void deleta(PessoaFisica contato) {

	     try {
	         PreparedStatement stmt = connection.prepareStatement("delete from Pessoa where Pessoaid=?");
	         stmt.setLong(1, contato.getPessoaId());
	         stmt.execute();
	         stmt.close();

	     } catch (SQLException e) {
	        throw new RuntimeException(e);
	     }
	 }
    @SuppressWarnings("unused")
	public void buscaId() {   
       try{
    	String sql = "SELECT MAX(pessoaId) as pessoaId FROM CLIENTE";   
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
package br.com.tecnonoticias.cadastro.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.cadastro.classes.Pessoa;

public class InserirDados {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroPU");
		EntityManager em = emf.createEntityManager();
		
		Pessoa cliente = new Pessoa();

		cliente.setNome("Edgar");
		cliente.setIdade(36);
		cliente.setSexo("M");
		cliente.setRua("Nove, 47");
		cliente.setBairro("Jd.Novo Bertioga");
		cliente.setCidade("Sarandi");
		cliente.setEstado("Paraná");

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();

		System.out.println("Cliente atualizado com sucesso! ");
	}
}
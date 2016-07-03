package br.com.tecnonoticias.cadastro.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.cadastro.classes.Pessoa;

public class AlterarDados {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroPU");
		EntityManager em = emf.createEntityManager();
		
		Pessoa cliente = new Pessoa();
		cliente.setNome("Anderson");
		cliente.setIdade(30);
		cliente.setSexo("M");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Cliente salvo com sucesso!");
		/*em.close();*/
	}
}
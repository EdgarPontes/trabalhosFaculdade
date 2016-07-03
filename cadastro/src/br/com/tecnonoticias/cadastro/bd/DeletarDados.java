package br.com.tecnonoticias.cadastro.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.cadastro.classes.Pessoa;

public class DeletarDados {

public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroPU");
		EntityManager em = emf.createEntityManager();
		
		Pessoa cliente = em.find(Pessoa.class, 1L);
		
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();

		System.out.println("Cliente removido com sucesso! ");
	}

}

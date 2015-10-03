package br.com.tecnonoticias.curso_jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.curso_jpa.modelo.Cliente;

public class AtualizandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1L);
		
		em.getTransaction().begin();
		cliente.setNome("Edgar");
		cliente.setIdade(36);
		em.getTransaction().commit();

		System.out.println("Cliente atualizado com sucesso! ");
	}

}

package br.com.tecnonoticias.curso_jpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.curso_jpa.modelo.Cliente;


public class ConsultaComJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		List<Cliente> clientes = em.createQuery("from Cliente where sexo = 'M'", Cliente.class)
									.getResultList();
		for (br.com.tecnonoticias.curso_jpa.modelo.Cliente cliente : clientes) {
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("----------------------------");
		}
	}
}
package br.com.tecnonoticias.curso_jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.curso_jpa.modelo.Cliente;

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1L);
		
		if(cliente != null){
			System.out.println("Nome "+ cliente.getNome() );
			System.out.println("Idade "+ cliente.getIdade() );
			System.out.println("Profissão "+ cliente.getProfissao() );
			System.out.println("Sexo "+ cliente.getSexo());
		}else{
			System.out.println("Cliente não encontrado! ");
		}
	
	}

}

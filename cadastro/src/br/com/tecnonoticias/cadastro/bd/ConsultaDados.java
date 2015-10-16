package br.com.tecnonoticias.cadastro.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.cadastro.classes.Pessoa;

public class ConsultaDados {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroPU");
		EntityManager em = emf.createEntityManager();
		
		Pessoa cliente = em.find(Pessoa.class, 2L);
		
		if(cliente != null){
			System.out.println("Nome "+ cliente.getNome() );
			System.out.println("Idade "+ cliente.getIdade() );
			System.out.println("Sexo "+ cliente.getSexo());
		}else{
			System.out.println("Cliente não encontrado! ");
		}
	
	}
}

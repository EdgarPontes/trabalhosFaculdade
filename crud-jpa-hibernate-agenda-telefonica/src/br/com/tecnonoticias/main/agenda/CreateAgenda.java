package br.com.tecnonoticias.main.agenda;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.modelo.agenda.AgendaTelefonica;

public class CreateAgenda {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agendaPU");
		EntityManager em = emf.createEntityManager();
		
		AgendaTelefonica agenda = new AgendaTelefonica();
		
		agenda.setNome("Victor");
		agenda.setTelefone("3222-3222");
		agenda.setDataRegistro(new Date());
		
		em.getTransaction().begin();
		em.persist(agenda);
		em.getTransaction().commit();
		
		System.out.println("Agenta incluida com sucesso! ");
		

	}
}
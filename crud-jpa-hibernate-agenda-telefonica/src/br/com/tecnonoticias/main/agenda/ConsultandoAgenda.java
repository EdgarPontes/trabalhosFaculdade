package br.com.tecnonoticias.main.agenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tecnonoticias.modelo.agenda.AgendaTelefonica;

public class ConsultandoAgenda {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agendaPU");
		EntityManager em = emf.createEntityManager();
		
		AgendaTelefonica agenda = em.find(AgendaTelefonica.class, 1L);
		
		if(agenda != null){
			System.out.println("Nome "+ agenda.getNome());
			System.out.println("Telefone "+ agenda.getTelefone());
			System.out.println("Data registro "+ agenda.getDataRegistro());
		}else{
			System.out.println("Agenda vazia! ");
		}
	}
}
package br.aula.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.aula.modelo.Cliente;

public class ClienteDao extends GenericDao{

	public ClienteDao() {
		super(Cliente.class);
	}
	
	public List<Cliente> consultar(String texto){
	
		TypedQuery q = getEm().createQuery("SELECT o FROM Cliente o WHERE o.nome LIKE ?", Cliente.class);
		q.setParameter(1, "%" + texto + "%");
		
		return q.getResultList();
		
	}
}
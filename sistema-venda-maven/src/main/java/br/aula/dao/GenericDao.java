package br.aula.dao;

import br.util.GerenciadorPersistencia;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Fernando God�y
 *
 * @param <T>
 */
public abstract class GenericDao<T extends Serializable> {

    private final EntityManager em = GerenciadorPersistencia.getEntityManager();

    private final Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getById(Long id) {
        return em.find(clazz, id);
    }

    public List<T> findAll() {
        TypedQuery<T> q = em.createQuery(" FROM " + clazz.getSimpleName(), clazz);
        return q.getResultList();
    }

    public void salvar(T clazz) {
        getTransaction().begin();
        em.persist(clazz);
        getTransaction().commit();
    }

    public T update(T clazz) {
        getTransaction().begin();
        T obj = em.merge(clazz);
        getTransaction().commit();
        return obj;
    }

    public void excluir(T clazz) {
        getTransaction().begin();
        em.remove(clazz);
        getTransaction().commit();
    }

    public void excluir(Long id) {
        excluir(getById(id));
    }

    private EntityTransaction getTransaction() {
        return em.getTransaction();
    }
    
    public EntityManager getEm() {
		return em;
	}
}
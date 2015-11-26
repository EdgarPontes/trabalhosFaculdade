package br.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

/**
 *
 * @author Fernando
 */
public class GerenciadorPersistencia {
    
    private static EntityManagerFactory entityManager;
    
    static {
      entityManager =  Persistence.createEntityManagerFactory("sistemavendaPU");
    }

    public static EntityManager getEntityManager() {
        return entityManager.createEntityManager();
    }
    
    
}

package br.ufrn.alugai.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufrn.alugai.model.Imovel;

public class GenericDao<T>  {
	 
	/**
     * Salva a entidade no BD.
     */
    public void save(Object obj) {
		EntityManager em = Banco.getEntityManager();
        em.getTransaction()
            .begin();
        em.persist(obj);
        em.getTransaction()
            .commit();
    }
    
    /**
     * Atualiza a entidade no BD.
     */
    public void update(Object obj) {
		EntityManager em = Banco.getEntityManager();
        em.getTransaction()
            .begin();
        em.merge(obj);
        em.getTransaction()
            .commit();
    }
    
    /**
     * Remove a entidade no BD.
     */
    public void delete(Object obj) {
		EntityManager em = Banco.getEntityManager();
        em.getTransaction()
            .begin();
        em.remove(obj);
        em.getTransaction()
            .commit();
    }
    
    /**
     * Busca a entidade no BD.
     */
    public Object findById(Class entityClass, long id) {
		EntityManager em = Banco.getEntityManager();
        return em.find(entityClass, id);
    }

 
}

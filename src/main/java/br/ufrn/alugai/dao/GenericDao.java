package br.ufrn.alugai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Favoritos;

@Repository
public class GenericDao<T>  {
	 
	/**
     * Salva a entidade no BD.
     */
    public void save(T obj) {
    	EntityManager em = Banco.getEntityManager();
		EntityTransaction et = em.getTransaction();
    	try
    	{
            et.begin();
            em.persist(obj);
            et.commit();
    	}
    	catch(Exception e)
    	{
    		et.rollback();
    		e.printStackTrace();
    	}
    	finally{
    	       //verifica se a transacao esta ativa e fecha caso ainda esteja aberta
    		if(et.isActive()) {
    			em.close();
    		}
    	}
		
    }
    
    /**
     * Atualiza a entidade no BD.
     */
    public void update(T obj) {
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
    public void delete(T entidade){
		EntityManager em = Banco.getEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.flush();
	    em.clear();
		em.getTransaction().commit();
    }
    
    /**
     * Busca a entidade no BD.
     */
    public T findById(Class entityClass, int id) {
		EntityManager em = Banco.getEntityManager();
        return (T) em.find(entityClass, id);
    }
    
   

}

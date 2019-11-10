package br.ufrn.alugai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Interesse;

@Repository
public class AnuncioDao extends GenericDao<Anuncio> {


    /**
     * Busca a entidade no BD.
     */
    public List<Anuncio> getAll() {
    	
    	EntityManager em = Banco.getEntityManager();
    	TypedQuery<Anuncio> query =
    		      em.createQuery("SELECT a FROM Anuncio a", Anuncio.class);
    	List<Anuncio> anuncios = query.getResultList();
		
		return anuncios;
    }
    

}

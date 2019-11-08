package br.ufrn.alugai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Imovel;

@Repository
public class AnuncioDao extends GenericDao<Anuncio> {


    /**
     * Busca a entidade no BD.
     */
    public List<Anuncio> getAll() {
    	
		EntityManager em = Banco.getEntityManager();
		Query query = (Query) em.createNativeQuery("SELECT * FROM anuncios WHERE id >= 0".toString());
        
		List<Anuncio> list = new ArrayList<Anuncio>();
		
		List<Object[]> anuncios = query.getResultList();
		String teste = "";
		for (Object[] a : anuncios) {
			
			Anuncio an = new Anuncio();
			an.setId(Integer.parseInt((String) a[0]));
			an.setCondominio((String) a[1]);
			an.setDescricao((String) a[2]);
			an.setIptu((String) a[3]);
			an.setPreco((String) a[4]);
			
			list.add(an);
		
		}
		
		return list;
		
    }
    
	
}

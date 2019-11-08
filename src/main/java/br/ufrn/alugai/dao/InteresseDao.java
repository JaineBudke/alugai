package br.ufrn.alugai.dao;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Interesse;
import br.ufrn.alugai.model.Usuario;

@Repository
public class InteresseDao extends GenericDao<Interesse> {

	
	public Interesse findInteresse(Interesse interesse) {
		EntityManager em = Banco.getEntityManager();
		try {
		Interesse i = (Interesse) em.createQuery("SELECT i from Interesse i WHERE i.valorMaximo = ?1 and "
				+ "i.quantidadeQuartos = ?2 and lower(i.bairro) like lower(?3) AND i.casa = ?4 AND "
				+ "i.apartamento = ?5 AND i.compra = ?6")
						.setParameter(1, interesse.getValorMaximo())
						.setParameter(2, interesse.getQuantidadeQuartos())
						.setParameter(3, interesse.getBairro())
						.setParameter(4, interesse.getCasa())
						.setParameter(5, interesse.getApartamento())
						.setParameter(6, interesse.getCompra())
						.getSingleResult();
			return i;
		} catch(NoResultException e) {
			return null;
		}
		
        
	}
}

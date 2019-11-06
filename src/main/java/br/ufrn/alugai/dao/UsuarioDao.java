package br.ufrn.alugai.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Usuario;

@Repository
public class UsuarioDao extends GenericDao<Usuario> {

	public <T extends Usuario> T findByEmailAddress(String email) {
		EntityManager em = Banco.getEntityManager();
		T u = null;
		try{
			u = (T) em.createQuery("SELECT u from Usuario u WHERE u.email = ?1 AND TYPE(u) = Vendedor")
						.setParameter(1, email).getResultList();
		} catch( NoResultException e ) {
			
			u = (T) em.createQuery("SELECT u FROM Usuario u WHERE u.email = ?1 AND TYPE(u) = Cliente")
					.setParameter(1, email).getResultList();
		}
				 
		
        return u;
	}
}

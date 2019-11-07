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

	public Usuario findByEmailAddress(String email) {
		EntityManager em = Banco.getEntityManager();
		Usuario u = (Usuario) em.createQuery("SELECT u from Usuario u WHERE u.email = ?1 ")
						.setParameter(1, email).getSingleResult();
				 
		
        return u;
	}
}

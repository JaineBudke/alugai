package br.ufrn.alugai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.dao.GenericDao;
import br.ufrn.alugai.model.Favoritos;
import br.ufrn.alugai.model.Usuario;

@Service
public class FavoritosService {

	
	private GenericDao<Favoritos> genericDao;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Transactional
	public Favoritos findById(int id) {
		return genericDao.findById(Favoritos.class, id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Favoritos entity) {
		genericDao.delete(entity);
	}
	
	@Transactional(readOnly=false)
	public void save(Favoritos entity) {
		
		genericDao.save(entity);
		
	}
	
	

}

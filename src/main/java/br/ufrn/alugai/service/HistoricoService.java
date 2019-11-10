package br.ufrn.alugai.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.dao.GenericDao;
import br.ufrn.alugai.model.Historico;
import br.ufrn.alugai.model.Usuario;

@Service
public class HistoricoService {

	

	@Autowired
	private GenericDao<Historico> genericDao;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Transactional(readOnly=false)
	public void save(Historico entity) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmailAdress(auth.getName());
        
        entity.setUsuario(user);
        
        LocalDateTime localTime = LocalDateTime.now();	
		entity.setData(localTime);
		
		genericDao.save(entity);

	}
	
	
}

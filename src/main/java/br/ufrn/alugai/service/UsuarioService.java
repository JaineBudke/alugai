package br.ufrn.alugai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.dao.UsuarioDao;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.repository.UsuarioRepository;

@Service
@Transactional(readOnly = true) // Por padrao, toda operacao eh ReadOnly
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioRepository;
	
	public Usuario autenticate(String emailAddress) {
		Usuario usuario = usuarioRepository.findByEmailAddress(emailAddress);
		if (usuario == null) {
			throw new RuntimeException("Usuário não cadastrado!");
		}
		return usuario;
	}
	
	public Usuario findByEmailAdress( String emailAddress) {
		Usuario usuario = usuarioRepository.findByEmailAddress(emailAddress);
		if (usuario == null) {
			throw new RuntimeException("Usuário não encontrado!");
		}
		return usuario;
	}

}

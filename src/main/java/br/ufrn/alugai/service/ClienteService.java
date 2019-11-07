package br.ufrn.alugai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Cliente save(Usuario entity) {
		final Cliente user = new Cliente();
		final Usuario usuario = new Usuario();
		usuario.setPassword(passwordEncoder.encode(entity.getPassword()));
		usuario.setName(entity.getName());
		usuario.setEmail(entity.getEmail());
		usuario.setCpf(entity.getCpf());
		user.setUsuario(usuario);
		if( entity.getEmail().isEmpty() || entity.getName().isEmpty() || entity.getPassword().isEmpty()) {
			//throw new InvalidUserException("Usuário inválido.");
		}
		
		Cliente userTemp =  clienteRepository.save(user);
		return userTemp;
	}
	
	@Transactional(readOnly = true)
	public Optional<Cliente> findById( int id) {
		return clienteRepository.findById(id);
	}

}

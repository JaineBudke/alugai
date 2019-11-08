package br.ufrn.alugai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.dao.GenericDao;
import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Telefone;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.model.Vendedor;
import br.ufrn.alugai.repository.ClienteRepository;
import br.ufrn.alugai.util.ClientForm;

@Service
public class ClienteService {
	
	@Autowired
	private GenericDao<Usuario> dao;
	
	@Autowired
	private TelefoneService telefoneService;
	
	@Autowired
	private InteresseService interesseService;
	
	@Autowired
	private GenericDao<Cliente> clienteDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Cliente save(ClientForm entity) {
		final Cliente cliente = new Cliente();
		final Usuario usuario = new Usuario();
		usuario.setPassword(passwordEncoder.encode(entity.getCliente().getUsuario().getPassword()));
		usuario.setName(entity.getCliente().getUsuario().getName());
		usuario.setEmail(entity.getCliente().getUsuario().getEmail());
		usuario.setCpf(entity.getCliente().getUsuario().getCpf());
		dao.save(usuario);
		//Salva usuario
		cliente.setUsuario(usuario);
		cliente.setRecebeConteudo(entity.getCliente().isRecebeConteudo());
		
		clienteDao.save(cliente);
		entity.getCliente().setId(cliente.getId());
		
		// Salva telefone
		//telefoneService.save(entity);
		for(Telefone tel: entity.getTelefones()) {
			Telefone telefone  = new Telefone();
			telefone.setDdd(tel.getDdd());
			telefone.setNumero(tel.getNumero());
			telefone.setTipo(tel.getTipo());
			telefone.setUsuario(usuario);
			
			telefoneService.save(telefone);
		}
		
		// Salva conta bancaria
		interesseService.save(entity);
		
		return cliente;
	}
	
	@Transactional(readOnly = true)
	public Cliente findById( long id) {
		return clienteDao.findById(Cliente.class, id);
	}

	public void update(Cliente c) {
		clienteDao.update(c);
		
	}

}

package br.ufrn.alugai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufrn.alugai.dao.GenericDao;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.model.Vendedor;
import br.ufrn.alugai.repository.VendedorRepository;
import br.ufrn.alugai.util.VendedorForm;

@Service
public class VendedorService {
	
	@Autowired
	private GenericDao<Vendedor> vendedorRepository;
	
	@Autowired
	private TelefoneService telefoneService;
	
	@Autowired 
	private GenericDao<Usuario> dao;
	
	@Autowired
	private ContaBancariaService contaService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Vendedor save(VendedorForm entity) {
		final Vendedor vendedor = new Vendedor();
		final Usuario usuario = new Usuario();
		usuario.setPassword(passwordEncoder.encode(entity.getUsuario().getUsuario().getPassword()));
		usuario.setName(entity.getUsuario().getUsuario().getName());
		usuario.setEmail(entity.getUsuario().getUsuario().getEmail());
		usuario.setCpf(entity.getUsuario().getUsuario().getCpf());
		dao.save(usuario);
		vendedor.setUsuario(usuario);
		
		vendedorRepository.save(vendedor);
		entity.getUsuario().setId(vendedor.getId());
		entity.getUsuario().getUsuario().setVendedor(vendedor);
		
		// Salva telefone
		telefoneService.save(entity);
		
		// Salva conta bancaria
		contaService.save(entity);
		
		return vendedor;
	}
	
	public Vendedor findById(int l) {
		Vendedor  v = vendedorRepository.findById(Vendedor.class, l);
		if( v != null)
			return v;
		else return null;
	}

}

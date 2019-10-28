package br.ufrn.alugai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufrn.alugai.model.Vendedor;
import br.ufrn.alugai.repository.VendedorRepository;
import br.ufrn.alugai.util.VendedorForm;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private TelefoneService telefoneService;
	
	@Autowired
	private ContaBancariaService contaService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Vendedor save(VendedorForm entity) {
		final Vendedor vendedor = new Vendedor();
		vendedor.setPassword(passwordEncoder.encode(entity.getUsuario().getPassword()));
		vendedor.setName(entity.getUsuario().getName());
		vendedor.setEmail(entity.getUsuario().getEmail());
		vendedor.setCpf(entity.getUsuario().getCpf());
		
		Vendedor result = vendedorRepository.save(vendedor);
		entity.getUsuario().setId(result.getId());
		
		// Salva telefone
		telefoneService.save(entity);
		
		// Salva conta bancaria
		contaService.save(entity);
		
		return result;
	}
	
	public Vendedor findById(int id) {
		Optional<Vendedor>  v = vendedorRepository.findById(id);
		if( v != null)
			return v.get();
		else return null;
	}

}

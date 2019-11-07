package br.ufrn.alugai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.alugai.model.Telefone;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.repository.TelefoneRepository;
import br.ufrn.alugai.util.VendedorForm;

@Service
public class TelefoneService {
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	public Telefone save( VendedorForm entity) {
		Telefone telefone = null;
		Usuario usuario = usuarioService.findByEmailAdress(entity.getUsuario().getUsuario().getEmail());
		for(Telefone tel: entity.getTelefones()) {
			telefone  = new Telefone();
			telefone.setUsuario(usuario);
			telefone.setDdd(tel.getDdd());
			telefone.setNumero(tel.getNumero());
			telefone.setTipo(tel.getTipo());
			
			telefoneRepository.save(telefone);
		}
		
		return telefone;
	}

}

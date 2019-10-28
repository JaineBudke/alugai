package br.ufrn.alugai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.alugai.model.ContaBancaria;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.model.Vendedor;
import br.ufrn.alugai.repository.ContaBancariaRepository;
import br.ufrn.alugai.util.VendedorForm;

@Service
public class ContaBancariaService {
	
	@Autowired
	private VendedorService usuarioService;

	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	public ContaBancaria save( VendedorForm entity) {
		Vendedor usuario = usuarioService.findById(entity.getUsuario().getId());
		if(usuario != null) {
			final ContaBancaria cb = new ContaBancaria();
			cb.setVendedor( usuario);
			cb.setAgencia(entity.getConta().getAgencia());
			cb.setConta(entity.getConta().getConta());
			cb.setNomeBanco(entity.getConta().getNomeBanco());
			
			return contaBancariaRepository.save(cb);
		}
		return null;
	}
}

package br.ufrn.alugai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.repository.AnuncioRepository;

@Service
@Transactional(readOnly = true)
public class AnuncioService {

	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	
	
	@Transactional(readOnly = false)
	public Anuncio saveAnuncio(Anuncio entity) {
		
		return anuncioRepository.save(entity);
		
	}
	
}

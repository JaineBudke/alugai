package br.ufrn.alugai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.dao.AnuncioDao;
import br.ufrn.alugai.dao.GenericDao;

import br.ufrn.alugai.model.Anuncio;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.repository.AnuncioRepository;

@Service
@Transactional(readOnly = true)
public class AnuncioService {

	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	private AnuncioDao anuncioDao;

	private GenericDao<Anuncio> GenericDao;

	
	@Transactional(readOnly = false)
	public Anuncio saveAnuncio(Anuncio entity) {
		
		return anuncioRepository.save(entity);
		
	}
	
	@Transactional(readOnly = false)
	public Anuncio saveAnuncio(Anuncio entity, Anuncio oldAnuncio) {
		
		Imovel imovel = oldAnuncio.getImovel();
		entity.setImovel(imovel);
		
		return anuncioRepository.save(entity);
		
	}
	
	@Transactional
	public Anuncio findById(int id) {
		return anuncioRepository.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Anuncio entity) {
		anuncioRepository.delete(entity);
	}

	

	@Transactional(readOnly=false)
	public List<Anuncio> getAllAnuncios() {
	
		return anuncioDao.getAll();
		
	}
	
}

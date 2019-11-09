package br.ufrn.alugai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	private GenericDao<Anuncio> genericDao;
	
	@Transactional(readOnly = false)
	public void saveAnuncio(Anuncio entity) {
		
		genericDao.save(entity);
		//return anuncioRepository.save(entity);
		
	}
	
	@Transactional(readOnly = false)
	public void saveAnuncio(Anuncio entity, Anuncio oldAnuncio) {
		
		Imovel imovel = oldAnuncio.getImovel();
		entity.setImovel(imovel);
		
		genericDao.update(entity);
		
		//return anuncioRepository.save(entity);
		
	}
	
	@Transactional
	public Anuncio findById(int id) {
		return genericDao.findById(Anuncio.class, id);
		//return anuncioRepository.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Anuncio entity) {
		genericDao.delete(entity);
		//anuncioRepository.delete(entity);
	}

	
}

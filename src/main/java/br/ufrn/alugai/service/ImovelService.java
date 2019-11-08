package br.ufrn.alugai.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.dao.GenericDao;
import br.ufrn.alugai.dao.AnuncioDao;
import br.ufrn.alugai.model.Endereco;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.model.StatusIm;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.model.Vendedor;
import br.ufrn.alugai.repository.ImovelRepository;
import br.ufrn.alugai.util.ImovelForm;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository imovelRepository;
	
	private AnuncioDao imovelDao;
	
	
	
	@Transactional(readOnly = false)
	public Imovel saveImovel(ImovelForm entity, Usuario user) {
		
		final Imovel imovel = new Imovel();
		imovel.setProprietario(user);
		imovel.setQuartos( entity.getImovel().getQuartos() );
		imovel.setTamanho( entity.getImovel().getTamanho() );
		imovel.setVagasGaragem( entity.getImovel().getVagasGaragem() );
		imovel.setTipoImovel( entity.getImovel().getTipoImovel() );
		
		imovel.setEndereco(entity.getEndereco());
		
		return imovelRepository.save(imovel);
		
	}
	
	@Transactional(readOnly = false)
	public Imovel updateImovel(Imovel entity, Imovel oldImovel, Usuario user) {
		
		int idEnd = oldImovel.getEndereco().getId_endereco();
		Endereco endereco = entity.getEndereco();
		endereco.setId_endereco(idEnd);
		entity.setEndereco(endereco);
		
		entity.setProprietario(user);
		return imovelRepository.save(entity);
	}
	
	
	@Transactional
	public Imovel findById(int id) {
		return imovelRepository.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Imovel entity) {
		imovelRepository.delete(entity);
	}


	
	
	
}

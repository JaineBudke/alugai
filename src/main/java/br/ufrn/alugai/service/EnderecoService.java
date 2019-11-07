package br.ufrn.alugai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufrn.alugai.model.Endereco;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.repository.EnderecoRepository;
import br.ufrn.alugai.repository.ImovelRepository;

@Service
public class EnderecoService {

	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

}

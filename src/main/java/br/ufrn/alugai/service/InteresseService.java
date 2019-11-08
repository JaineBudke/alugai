package br.ufrn.alugai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.alugai.dao.GenericDao;
import br.ufrn.alugai.dao.InteresseDao;
import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Interesse;
import br.ufrn.alugai.model.Telefone;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.util.ClientForm;

@Service
public class InteresseService {
	@Autowired
	private InteresseDao dao;
	
	public Interesse save( ClientForm entity) {
		Interesse interesse = dao.findInteresse(entity.getInteresse());;
		// Se interesse já estiver criado, associa novo cliente
		// Senão, cadastra e associa
		if( interesse != null) {
			interesse.getClientes().add(entity.getCliente());
			dao.update(interesse);
		} else {
			interesse = new Interesse();
			interesse.setApartamento(entity.getInteresse().getApartamento());
			interesse.setBairro(entity.getInteresse().getBairro());
			interesse.setCasa(entity.getInteresse().getCasa());
			interesse.setCompra(entity.getInteresse().getCompra());
			interesse.setQuantidadeQuartos(entity.getInteresse().getQuantidadeQuartos());
			interesse.setValorMaximo(entity.getInteresse().getValorMaximo());
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes.add(entity.getCliente());
			interesse.setClientes(clientes);
			
			dao.save(interesse);
		}
		
		return interesse;
	}

}

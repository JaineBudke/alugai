package br.ufrn.alugai.util;

import java.util.List;

import br.ufrn.alugai.model.Telefone;
import br.ufrn.alugai.model.Cliente;
import br.ufrn.alugai.model.Interesse;

public class ClientForm {
	private Cliente cliente;
	private Interesse interesse;
	private List<Telefone> telefones;
	/**
	 * @return the usuario
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setCliente(Cliente usuario) {
		this.cliente = usuario;
	}
	/**
	 * @return the telefones
	 */
	public List<Telefone> getTelefones() {
		return telefones;
	}
	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	/**
	 * @return the interesse
	 */
	public Interesse getInteresse() {
		return interesse;
	}
	/**
	 * @param interesse the interesse to set
	 */
	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

}

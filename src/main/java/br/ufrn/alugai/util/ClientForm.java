package br.ufrn.alugai.util;

import java.util.List;

import br.ufrn.alugai.model.Telefone;
import br.ufrn.alugai.model.Cliente;

public class ClientForm {
	private Cliente usuario;
	private List<Telefone> telefones;
	/**
	 * @return the usuario
	 */
	public Cliente getCliente() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
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

}

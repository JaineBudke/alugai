package br.ufrn.alugai.util;

import java.util.List;

import br.ufrn.alugai.model.ContaBancaria;
import br.ufrn.alugai.model.Telefone;
import br.ufrn.alugai.model.Usuario;
import br.ufrn.alugai.model.Vendedor;

/**
 * Estrutura para agregar telefone, dados de usuário e dados de
 * conta bancária
 * @author mayra
 *
 */
public class VendedorForm {
	private Vendedor usuario;
	private ContaBancaria conta;
	private List<Telefone> telefones;
	/**
	 * @return the usuario
	 */
	public Vendedor getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Vendedor usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the conta
	 */
	public ContaBancaria getConta() {
		return conta;
	}
	/**
	 * @param conta the conta to set
	 */
	public void setConta(ContaBancaria conta) {
		this.conta = conta;
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

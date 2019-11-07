package br.ufrn.alugai.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.ufrn.alugai.domain.TipoInteresse;

@Entity
@Table(name = "interesses")
public class Interesse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3907175049642861581L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="valor_maximo")
	private Float valorMaximo;
	
	@Column(name="quantidade_quartos")
	private Integer quantidadeQuartos;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="casa")
	private Boolean casa;
	
	@Column(name="apartamento")
	private Boolean apartamento;
	
	@Column(name="compra")
	private Boolean compra;
	
	@ManyToMany
	private List<Cliente> clientes;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Float valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Integer getQuantidadeQuartos() {
		return quantidadeQuartos;
	}

	public void setQuantidadeQuartos(Integer quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Boolean getCasa() {
		return casa;
	}

	public void setCasa(Boolean casa) {
		this.casa = casa;
	}

	public Boolean getApartamento() {
		return apartamento;
	}

	public void setApartamento(Boolean apartamento) {
		this.apartamento = apartamento;
	}

	public Boolean getCompra() {
		return compra;
	}

	public void setCompra(Boolean compra) {
		this.compra = compra;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

}

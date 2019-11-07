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
	
	@Column(name="interesse")
	private TipoInteresse interesse;
	
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

	/**
	 * @return the interesse
	 */
	public TipoInteresse getInteresse() {
		return interesse;
	}

	/**
	 * @param interesse the interesse to set
	 */
	public void setInteresse(TipoInteresse interesse) {
		this.interesse = interesse;
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

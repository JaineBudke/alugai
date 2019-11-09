package br.ufrn.alugai.model;

import javax.persistence.Table;

import br.ufrn.alugai.domain.TipoTelefone;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;

/**
 * 
 * @author mayra
 *
 */
@Entity
@Table(name = "telefones")
public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH
        }, fetch= FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "ddd")
	private String ddd;
	
	@Column(name =  "tipo")
	private TipoTelefone tipo;
	
	@Column(name = "numero")
	private String numero;

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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the ddd
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * @param ddd the ddd to set
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * @return the tipo
	 */
	public TipoTelefone getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
}

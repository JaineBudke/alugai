package br.ufrn.alugai.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "favoritos")
public class Favoritos implements Serializable  {

	
	/**
	 * Serial version uid (default)
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "data")
	private LocalDateTime data;

	@ManyToOne()
	@JoinColumn(name="id_cliente")
    private Usuario id_cliente;

	@ManyToOne()
	@JoinColumn(name="id_anuncio")
    private Anuncio id_anuncio;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime date) {
		this.data = date;
	}


	public Usuario getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Usuario id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Anuncio getId_anuncio() {
		return id_anuncio;
	}

	public void setId_anuncio(Anuncio id_anuncio) {
		this.id_anuncio = id_anuncio;
	}


}

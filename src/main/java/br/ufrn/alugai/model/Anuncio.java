package br.ufrn.alugai.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "anuncios")
public class Anuncio implements Serializable {


	/**
	 * Serial version uid (default)
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "preco")
	private String preco;

	
	@Column(name = "iptu")
	private String iptu;

	@Column(name = "condominio")
	private String condominio;


	@ManyToOne()
	@JoinColumn(name="id_imovel")
    private Imovel id_imovel;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getIptu() {
		return iptu;
	}

	public void setIptu(String iptu) {
		this.iptu = iptu;
	}

	public String getCondominio() {
		return condominio;
	}

	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}

	public Imovel getImovel() {
		return id_imovel;
	}

	public void setImovel(Imovel imovel) {
		this.id_imovel = imovel;
	}


	
}

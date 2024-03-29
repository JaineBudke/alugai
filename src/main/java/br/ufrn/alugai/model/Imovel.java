package br.ufrn.alugai.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "imoveis")
@Inheritance(strategy = InheritanceType.JOINED)
public class Imovel implements Serializable{

	

	/**
	 * Serial version uid (default)
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "quartos")
	private String quartos;

	@Column(name = "vagas_garagem")
	private int vagasGaragem;
	
	@Column(name = "tamanho")
	private String tamanho;
	
	@Column(name = "tipo_imovel")
	private String tipoImovel;
	
	@ManyToOne()
	@JoinColumn(name="id_proprietario")
    private Usuario proprietario;
	
	@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="id_status")
    private StatusIm status;

	@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="id_endereco")
    private Endereco endereco;
	
	@OneToMany(mappedBy="id_imovel", cascade = CascadeType.ALL)
    private List<Anuncio> anuncios;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuartos() {
		return quartos;
	}

	public void setQuartos(String quartos) {
		this.quartos = quartos;
	}

	public int getVagasGaragem() {
		return vagasGaragem;
	}

	public void setVagasGaragem(int vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public StatusIm getStatus() {
		return status;
	}

	public void setStatus(StatusIm status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	
	
	
}

package br.ufrn.alugai.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
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
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7088997936960839073L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "recebe_conteudo")
	private boolean recebeConteudo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToMany(mappedBy="clientes")
	private List<Interesse> interesses;

	/**
	 * @return the recebeConteudo
	 */
	public boolean isRecebeConteudo() {
		return recebeConteudo;
	}

	/**
	 * @param recebeConteudo the recebeConteudo to set
	 */
	public void setRecebeConteudo(boolean recebeConteudo) {
		this.recebeConteudo = recebeConteudo;
	}

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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the interesses
	 */
	public List<Interesse> getInteresses() {
		return interesses;
	}

	/**
	 * @param interesses the interesses to set
	 */
	public void setInteresses(List<Interesse> interesses) {
		this.interesses = interesses;
	}
	
	

}

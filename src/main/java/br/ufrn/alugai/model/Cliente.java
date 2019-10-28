package br.ufrn.alugai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Cliente extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7088997936960839073L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "recebe_conteudo")
	private boolean recebeConteudo;

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
	
	

}

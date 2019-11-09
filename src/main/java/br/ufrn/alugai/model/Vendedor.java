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
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7088997936960839073L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "plano_mensal")
	private String planoMensal;
	
	@OneToMany(mappedBy="vendedor", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List<ContaBancaria> contas_bancarias;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH
        })
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

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
	 * @return the planoMensal
	 */
	public String getPlanoMensal() {
		return planoMensal;
	}

	/**
	 * @param planoMensal the planoMensal to set
	 */
	public void setPlanoMensal(String planoMensal) {
		this.planoMensal = planoMensal;
	}

	/**
	 * @return the contas_bancarias
	 */
	public List<ContaBancaria> getContas_bancarias() {
		return contas_bancarias;
	}

	/**
	 * @param contas_bancarias the contas_bancarias to set
	 */
	public void setContas_bancarias(List<ContaBancaria> contas_bancarias) {
		this.contas_bancarias = contas_bancarias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}

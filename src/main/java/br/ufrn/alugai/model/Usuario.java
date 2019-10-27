/**
 * 
 */
package br.ufrn.alugai.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.OneToMany;

/**
 * @author mayra
 *
 */
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{

	/**
	 * Serial version uid (default)
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List<Telefone> telefones;
	
	@Column(name = "data_nascimento")
	@Temporal(value = TemporalType.DATE)
	private Date dataNascimento;


	/**
	 * Get the id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	
	/**
	 * Update the id 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
	/**
	 * Get the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Update the name 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Get the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * Update the email 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * Get the password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * Update the password 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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


	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}


	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}

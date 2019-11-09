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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author mayra
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO")
    @SequenceGenerator(name="SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
	@Column(name = "id")
	public Integer id;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@Column(name = "email", unique=true)
	@NotNull
	private String email;

	@Column(name = "senha")
	@NotNull
	private String password;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List<Telefone> telefones;
	
	@Column(name = "data_nascimento")
	@Temporal(value = TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name = "cpf", unique=true)
	@NotNull
	private String cpf;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private Cliente cliente;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private Vendedor vendedor;

	@OneToMany(mappedBy="proprietario", cascade = CascadeType.ALL)
    private List<Imovel> imoveis;
	
	@OneToMany(mappedBy="id_cliente", cascade = CascadeType.ALL)
    private List<Favoritos> favoritos;


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
		return nome;
	}

	
	/**
	 * Update the name 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.nome = name;
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


	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}


	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public List<Imovel> getImoveis() {
		return imoveis;
	}


	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}


	public List<Favoritos> getFavoritos() {
		return favoritos;
	}


	public void setFavoritos(List<Favoritos> favoritos) {
		this.favoritos = favoritos;
	}

	
	
	
}

package br.ufrn.alugai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "status")
public class StatusIm implements Serializable {


	/**
	 * Serial version uid (default)
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_status;
	
	
	@Column(name = "status")
	private String status;


	public Integer getId_status() {
		return id_status;
	}


	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

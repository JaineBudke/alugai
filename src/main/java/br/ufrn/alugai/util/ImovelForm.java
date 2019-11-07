package br.ufrn.alugai.util;


import br.ufrn.alugai.model.Endereco;
import br.ufrn.alugai.model.Imovel;
import br.ufrn.alugai.model.StatusIm;


public class ImovelForm {

	private Imovel imovel;
	private StatusIm status;
	private Endereco endereco;
	
	
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public StatusIm getStatus() {
		return status;
	}
	public void setStatus(StatusIm status) {
		this.status = status;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}

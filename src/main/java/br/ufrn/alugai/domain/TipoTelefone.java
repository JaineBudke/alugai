package br.ufrn.alugai.domain;

/**
 * @author mayra
 *
 */
public enum TipoTelefone {
		RESIDENCIAL,COMERCIAL;
	
	@Override
	public String toString() {
		switch(this) {
	    	case RESIDENCIAL: return "residencial";
	    	case COMERCIAL: return "comercial";
	    	default: throw new IllegalArgumentException();
	    }
	}
}
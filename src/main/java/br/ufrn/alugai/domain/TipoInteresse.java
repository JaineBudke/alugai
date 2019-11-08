package br.ufrn.alugai.domain;

public enum TipoInteresse {
	CASA, APARTAMENTO, CASA_DE_PRAIA, KITNET;
	
	@Override
	public String toString() {
		switch(this) {
	    	case CASA: return "casa";
	    	case APARTAMENTO: return "apartamento";
	    	default: throw new IllegalArgumentException();
	    }
	}
}

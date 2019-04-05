package br.com.carpal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LocDetalhesPK implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	@JoinColumn(name = "locacao_codigo")
	private Locacao locacao;

	
	@ManyToOne
	@JoinColumn(name = "ferramenta_codigo")
	private Ferramenta ferramenta;

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Ferramenta getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ferramenta == null) ? 0 : ferramenta.hashCode());
		result = prime * result + ((locacao == null) ? 0 : locacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocDetalhesPK other = (LocDetalhesPK) obj;
		if (ferramenta == null) {
			if (other.ferramenta != null)
				return false;
		} else if (!ferramenta.equals(other.ferramenta))
			return false;
		if (locacao == null) {
			if (other.locacao != null)
				return false;
		} else if (!locacao.equals(other.locacao))
			return false;
		return true;
	}

}

package br.com.carpal.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LocacaoDetalhes implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private LocDetalhesPK codigo = new LocDetalhesPK();

	private Integer quantidade;

	public LocacaoDetalhes() {

	}

	public LocacaoDetalhes(Locacao locacao, Ferramenta ferramenta, Integer quantidade) {
		super();
		codigo.setLocacao(locacao);
		codigo.setFerramenta(ferramenta);
		this.quantidade = quantidade;
	}

	/* ==== acessoiando os detalhes da locação com suas referencias de clases==== */
	@JsonIgnore
	public Locacao getLocacao() {
		return codigo.getLocacao();
	}

	public void setLocacao(Locacao locacao) {
		codigo.setLocacao(locacao);
	}

	public Ferramenta getFerramenta() {
		return codigo.getFerramenta();
	}

	public void setFerramenta(Ferramenta ferramenta) {
		codigo.setFerramenta(ferramenta);
	}

	/* === / ====== */

	public LocDetalhesPK getCodigo() {
		return codigo;
	}

	public void setCodigo(LocDetalhesPK codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		LocacaoDetalhes other = (LocacaoDetalhes) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

package br.com.carpal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	private Long codFilial;

	@Column(nullable = false, length = 100)
	private String descricao;

	@Column(nullable = false, length = 100)
	private String cnpj;

	public Empresa() {

	}

	public Empresa(Long codFilial, String descricao, String cnpj) {
		super();
		this.codFilial = codFilial;
		this.descricao = descricao;
		this.cnpj = cnpj;
	}

	public Long getCodFilial() {
		return codFilial;
	}

	public void setCodFilial(Long codFilial) {
		this.codFilial = codFilial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFilial == null) ? 0 : codFilial.hashCode());
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
		Empresa other = (Empresa) obj;
		if (codFilial == null) {
			if (other.codFilial != null)
				return false;
		} else if (!codFilial.equals(other.codFilial))
			return false;
		return true;
	}

}

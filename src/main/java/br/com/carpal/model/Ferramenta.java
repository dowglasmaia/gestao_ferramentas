package br.com.carpal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Ferramenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	@NotEmpty
	private String nome;
	
	@Column(length = 100, nullable = false)
	@NotEmpty
	private String modelo;

	@Column(length = 20)
	private Integer codigoCNH;

	@Column(length = 20)
	private Integer codigoInterno;

	@Column(length = 20)
	private Integer estoque;

	@Column(precision = 12, scale = 2)
	private Double valorCusto;

	@ManyToOne
	private Fabricante fabricante;

	@ManyToOne
	private Empresa empresa;

	@ManyToOne
	private Locacao locacao;

	

	public Ferramenta() {

	}

	public Ferramenta(Long id, @NotEmpty String nome, Integer codigoCNH, Integer codigoInterno, Integer estoque,
			Double valorCusto, Fabricante fabricante, Empresa empresa, Locacao locacao, String modelo) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoCNH = codigoCNH;
		this.codigoInterno = codigoInterno;
		this.estoque = estoque;
		this.valorCusto = valorCusto;
		this.fabricante = fabricante;
		this.empresa = empresa;
		this.locacao = locacao;
		this.modelo = modelo;
	}

	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigoCNH() {
		return codigoCNH;
	}

	public void setCodigoCNH(Integer codigoCNH) {
		this.codigoCNH = codigoCNH;
	}

	public Integer getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(Integer codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ferramenta other = (Ferramenta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

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
	private Long codigo;

	@Column(length = 100, nullable = false)
	@NotEmpty
	private String descricao;

	@Column(length = 100, nullable = false)
	@NotEmpty
	private String modelo;

	@Column(length = 20)
	private Integer codigoNh;

	@Column
	private String aplicabilidade;

	@Column(length = 20)
	private Integer quantidade;

	@Column(length = 20)
	private Integer estoque;

	@Column(precision = 12, scale = 2)
	private Double preco;

	@ManyToOne
	private Fabricante fabricante;

	public Ferramenta() {

	}

	public Ferramenta(Long codigo, @NotEmpty String descricao, @NotEmpty String modelo, Integer codigoNh,
			String aplicabilidade, Integer quantidade, Integer estoque, Double preco, Fabricante fabricante) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.modelo = modelo;
		this.codigoNh = codigoNh;
		this.aplicabilidade = aplicabilidade;
		this.quantidade = quantidade;
		this.estoque = estoque;
		this.preco = preco;
		this.fabricante = fabricante;

	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getCodigoNh() {
		return codigoNh;
	}

	public void setCodigoNh(Integer codigoNh) {
		this.codigoNh = codigoNh;
	}

	public String getAplicabilidade() {
		return aplicabilidade;
	}

	public void setAplicabilidade(String aplicabilidade) {
		this.aplicabilidade = aplicabilidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {		
		this.estoque = estoque;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


}

package br.com.carpal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.aspectj.weaver.ast.Literal;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Dowglas Maia Skype: live:dowglasmaia E-mail:dowglasmaia@live.com
 *         Linkedin: www.linkedin.com/in/dowglasmaia
 */

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

	@JsonIgnore
	@OneToMany(mappedBy = "codigo.ferramenta")
	private Set<LocacaoDetalhes> locacaoDetalhes = new HashSet<>();

	
	@JsonIgnore
	public List<Locacao> getListLocacoes() {
		List<Locacao> lista = new ArrayList<>();
		for (LocacaoDetalhes x : locacaoDetalhes) {
			lista.add(x.getLocacao());
		}
		return lista;
	}

	
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

	public Set<LocacaoDetalhes> getLocacaoDetalhes() {
		return locacaoDetalhes;
	}

	public void setLocacaoDetalhes(Set<LocacaoDetalhes> locacaoDetalhes) {
		this.locacaoDetalhes = locacaoDetalhes;
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
		Ferramenta other = (Ferramenta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

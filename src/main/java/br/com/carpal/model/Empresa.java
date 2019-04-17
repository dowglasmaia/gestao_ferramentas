package br.com.carpal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private Integer codFilial;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 100)
	private String cnpj;

	@JsonIgnore
	@OneToMany(mappedBy = "empresa")
	private List<Usuario> usuarios = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "empresa")
	private List<Funcionario> funcionario = new ArrayList<>();

	public Empresa() {
	}

	public Empresa(Long codigo, Integer codFilial, String nome, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.codFilial = codFilial;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getCodFilial() {
		return codFilial;
	}

	public void setCodFilial(Integer codFilial) {
		this.codFilial = codFilial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
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
		Empresa other = (Empresa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

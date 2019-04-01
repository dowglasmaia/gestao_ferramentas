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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(nullable = false, length = 100)
	private String nome;	

	@Column(nullable = false, length = 100)
	private String cnpj;

	@JsonIgnore
	@OneToMany(mappedBy = "empresa")
	private List<Usuario> usuarios = new ArrayList<>();

	public Empresa() {
	}

	public Empresa(Long codigo, String nome, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

}

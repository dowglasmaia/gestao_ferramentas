package br.com.carpal.model.dto;

import java.io.Serializable;

import br.com.carpal.model.Cargo;
import br.com.carpal.model.Empresa;

public class UsuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long codigo;

	private Integer matricula;

	private String nome;

	private String cpf;

	private String senha;

	private String token;

	private String contato;

	private Cargo cargo;

	private Empresa empresa;

	// TODO Auto-generated constructor stub
	public UsuarioNewDTO() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}

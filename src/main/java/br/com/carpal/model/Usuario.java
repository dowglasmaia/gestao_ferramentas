package br.com.carpal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private Integer matricula;

	@Column(length = 80, nullable = false)
	@NotEmpty
	private String nome;

	/* Usar o CPF como Login */
	@Column(length = 16, nullable = false)
	@NotEmpty
	private String cpf;

	/* Senha */
	@JsonIgnore // não mostra a senha quando recupera os Dados do usuario.
	@Column(length = 100, nullable = false)
	@NotEmpty
	private String senha;

	// Não é Gravado no banco de Dados
	@Transient
	private String token;

	@Column(length = 17, nullable = false)
	@NotEmpty
	private String contato;

	@ManyToOne // Usuario tem um cargo
	private Cargo cargo;

	@JsonIgnore
	@ManyToOne
	private Empresa empresa;

	@JsonIgnore
	@OneToMany(mappedBy = "usuarioRequerent")
	private List<Locacao> locacaos = new ArrayList<>();

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "usuarioLogado") private List<Locacao> locacaosLog =
	 * new ArrayList<>();
	 */
	public Usuario() {

	}

	public Usuario(Long codigo, Integer matricula, @NotEmpty String nome, @NotEmpty String cpf, String senha,
			@NotEmpty String contato, Cargo cargo, Empresa empresa) {
		super();
		this.codigo = codigo;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.cargo = cargo;
		this.empresa = empresa;
		this.senha = senha;
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

	public List<Locacao> getLocacaos() {
		return locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}
	/*
	 * public List<Locacao> getLocacaosLog() { return locacaosLog; }
	 */

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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

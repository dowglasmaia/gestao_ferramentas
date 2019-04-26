package br.com.carpal.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.carpal.model.enums.Perfil;

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

	@Column(length = 12, nullable = false, unique = true)	
	@NotEmpty(message = "Campo CPF Obrigatórido")
	@CPF(message = "CPF Ínvalido")
	private String cpf;

	@Column(length = 17, nullable = false)
	@NotEmpty
	private String contato;

	@ManyToOne // Usuario tem um cargo
	private Cargo cargo;

	@ManyToOne
	private Empresa empresa;

	/* Senha */
	@JsonIgnore // não mostra a senha quando recupera os Dados do usuario.
	@Column(length = 100, nullable = false)
	@NotEmpty
	private String senha;

	@ElementCollection(fetch = FetchType.EAGER) // garante que quando buscar o usuario no BD, Carregue tbm seus Perfis.
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	// Não é Gravado no banco de Dados
	@Transient
	private String token;

	public Usuario() {
		addPerfil(Perfil.USUARIO); // Definindo Perfil Padrão para Todos os usuario Cadastrados

	}

	public Usuario(Long codigo, Integer matricula, @NotEmpty String nome,
			@NotEmpty(message = "Campo CPF Obrigatórido") @CPF(message = "CPF Ínvalido") String cpf,
			@NotEmpty String contato, Cargo cargo, Empresa empresa,
			@NotEmpty(message = "Campo Login Obrigatório") @CPF(message = "CPF Ínvalido , Para Login") 
			@NotEmpty String senha) {
		super();
		this.codigo = codigo;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.cargo = cargo;
		this.empresa = empresa;
		
		this.senha = senha;
		addPerfil(Perfil.USUARIO);
	}

	// Retorna os Perfis dos Clientes do Enum Perfil
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	/* Add Perfil */
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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

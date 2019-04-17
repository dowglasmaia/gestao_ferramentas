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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // Gera uma Tabela Para Cada Herança da mesma
public class Funcionario implements Serializable {
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

	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<Locacao> locacaos = new ArrayList<>();

	public Funcionario() {

	}

	public Funcionario(Long codigo, Integer matricula, @NotEmpty String nome,
			@NotEmpty(message = "Campo CPF Obrigatórido") @CPF(message = "CPF Ínvalido") String cpf,
			@NotEmpty String contato, Cargo cargo, Empresa empresa) {
		super();
		this.codigo = codigo;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.cargo = cargo;
		this.empresa = empresa;
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

	public List<Locacao> getLocacaos() {
		return locacaos;
	}

}

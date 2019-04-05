package br.com.carpal.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.carpal.model.enums.Situacao;

@Entity
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraLocIn;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraLocEnd;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@OneToMany(mappedBy = "codigo.locacao", cascade= CascadeType.ALL)
	private Set<LocacaoDetalhes> locacaoDetalhes = new HashSet<>();

	@ManyToOne
	private Usuario usuarioRequerent;

	//@ManyToOne
	//private Usuario usuarioLogado;

	public Locacao() {
		// TODO Auto-generated constructor stub
	}

	public Locacao(Long codigo, LocalDateTime dataHoraLocIn, LocalDateTime dataHoraLocEnd, Situacao situacao,
			Usuario usuarioRequerent) {
		super();
		this.codigo = codigo;
		this.dataHoraLocIn = dataHoraLocIn;
		this.dataHoraLocEnd = dataHoraLocEnd;
		this.situacao = situacao;
		this.usuarioRequerent = usuarioRequerent;
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataHoraLocIn() {
		return dataHoraLocIn;
	}

	public void setDataHoraLocIn(LocalDateTime dataHoraLocIn) {
		this.dataHoraLocIn = dataHoraLocIn;
	}

	public LocalDateTime getDataHoraLocEnd() {
		return dataHoraLocEnd;
	}

	public void setDataHoraLocEnd(LocalDateTime dataHoraLocEnd) {
		this.dataHoraLocEnd = dataHoraLocEnd;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Set<LocacaoDetalhes> getLocacaoDetalhes() {
		return locacaoDetalhes;
	}

	public void setLocacaoDetalhes(Set<LocacaoDetalhes> locacaoDetalhes) {
		this.locacaoDetalhes = locacaoDetalhes;
	}

	public Usuario getUsuarioRequerent() {
		return usuarioRequerent;
	}

	public void setUsuarioRequerent(Usuario usuarioRequerent) {
		this.usuarioRequerent = usuarioRequerent;
	}
	
	
/*
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
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
		Locacao other = (Locacao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

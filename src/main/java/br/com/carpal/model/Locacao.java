package br.com.carpal.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@Column(length = 50, nullable = false)
	@NotNull
	private Integer qtdaLocada;

	@ManyToOne
	private Usuario usuario;

	public Locacao() {

	}

	public Locacao(Long codigo, LocalDateTime dataHoraLocIn, LocalDateTime dataHoraLocEnd, @NotNull Integer qtdaLocada,
			Usuario usuario) {
		super();
		this.codigo = codigo;
		this.dataHoraLocIn = dataHoraLocIn;
		this.dataHoraLocEnd = dataHoraLocEnd;
		this.qtdaLocada = qtdaLocada;
		this.usuario = usuario;
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

	public Integer getQtdaLocada() {
		return qtdaLocada;
	}

	public void setQtdaLocada(Integer qtdaLocada) {
		this.qtdaLocada = qtdaLocada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Locacao other = (Locacao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

}

package br.com.carpal.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraLocIn;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraLocEnd;

	@Column(length = 50, nullable = false)
	@NotNull
	private Integer qtdaLocada;

	public Locacao() {

	}

	public Locacao(Long id, LocalDateTime dataHoraLocIn, LocalDateTime dataHoraLocEnd, @NotNull Integer qtdaLocada) {
		super();
		this.id = id;
		this.dataHoraLocIn = dataHoraLocIn;
		this.dataHoraLocEnd = dataHoraLocEnd;
		this.qtdaLocada = qtdaLocada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

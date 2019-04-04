package br.com.carpal.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.carpal.model.Ferramenta;
import br.com.carpal.model.Locacao;
import br.com.carpal.model.Usuario;

public class LocacaoDTO {

	private Long codigo;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraLocIn;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataHoraLocEnd;

	private Integer quantidade;

	private String situacao;

	private Usuario usuarioRequerent;

	private Usuario usuarioLogado;

	private Ferramenta ferramenta;

	private Locacao locacao;

	
	public LocacaoDTO() {
		
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Usuario getUsuarioRequerent() {
		return usuarioRequerent;
	}

	public void setUsuarioRequerent(Usuario usuarioRequerent) {
		this.usuarioRequerent = usuarioRequerent;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Ferramenta getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

}

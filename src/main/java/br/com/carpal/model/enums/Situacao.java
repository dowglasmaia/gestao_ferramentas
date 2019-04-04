package br.com.carpal.model.enums;

public enum Situacao {

	A("AB", "Aberto"), F("FC", "Fechado");

	private String sigla;
	private String descricao;

	private Situacao() {

	}

	private Situacao(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

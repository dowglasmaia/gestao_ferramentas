package br.com.carpal.model.enums;

public enum Obrigatoriedade {
	OBG("OBGRIGATORIO", "Obrigatório"),
	RCM("RECOMENDADA", "Recomendada");

	private String cod;
	private String descricao;

	private Obrigatoriedade(String cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// **Getters
	public String getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

}

package br.com.carpal.model.enums;

public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"),
	USUARIO(2, "ROLE_USUARIO");

	private int cod;
	private String descricao;

	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// **Getters
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	// metod para converter Usuario para enum
	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Inválido: " + cod);

	}

}

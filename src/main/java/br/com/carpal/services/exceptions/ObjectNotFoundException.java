package br.com.carpal.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	// Sobrecargo do Contrutor passando a causa de exception
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}

package com.challengeinc.challenge.services.exceptions;

public class ExcecaoComentarioDuplicado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcecaoComentarioDuplicado(String msg) {
		super(msg);
	}
}

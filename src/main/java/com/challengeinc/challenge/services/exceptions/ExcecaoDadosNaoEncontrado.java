package com.challengeinc.challenge.services.exceptions;

//@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExcecaoDadosNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcecaoDadosNaoEncontrado(String msg) {
		super(msg);
	}
}

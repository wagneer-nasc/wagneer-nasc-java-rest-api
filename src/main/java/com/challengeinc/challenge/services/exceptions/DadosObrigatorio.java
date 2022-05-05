package com.challengeinc.challenge.services.exceptions;

public class DadosObrigatorio extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DadosObrigatorio(String msg) {
		super(msg);
	}
}

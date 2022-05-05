package com.challengeinc.challenge.erros;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.challengeinc.challenge.services.exceptions.DadosObrigatorio;
import com.challengeinc.challenge.services.exceptions.ExcecaoAvaliacaoRN;
import com.challengeinc.challenge.services.exceptions.ExcecaoComentarioDuplicado;
import com.challengeinc.challenge.services.exceptions.ExcecaoDadosNaoEncontrado;

@ControllerAdvice
public class ExceptionHandler {
 
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcecaoDadosNaoEncontrado.class)
	public ResponseEntity<Error> dadosNaoEncontrado(ExcecaoDadosNaoEncontrado e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setError("Not found");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcecaoAvaliacaoRN.class)
	public ResponseEntity<Error> avaliacaoNaoPodeSerMaiorQue5EMenorQue0(ExcecaoAvaliacaoRN e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.LENGTH_REQUIRED.value());
		error.setMessage(e.getMessage());
		error.setError("length incorrect");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body(error);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(DadosObrigatorio.class)
	public ResponseEntity<Error> dadosObrigatorio(DadosObrigatorio e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setError("Dados obrigatorio");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcecaoComentarioDuplicado.class)
	public ResponseEntity<Error> excecaoComentarioDuplicado(ExcecaoComentarioDuplicado e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage(e.getMessage());
		error.setError("Comentário duplicado");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}
}

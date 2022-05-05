package com.challengeinc.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.challengeinc.challenge.interfaces.WsBuscarFilmesInterface;
import com.challengeinc.challenge.models.TemplateRetornoWs;
import com.challengeinc.challenge.services.WsServiceBuscarFilmes;

@RestController 
public class WsBuscarFilmesController implements WsBuscarFilmesInterface {

	@Autowired
	private WsServiceBuscarFilmes wsServiceBuscarFilmes;
	
	@GetMapping("/{title}")
 	public ResponseEntity<TemplateRetornoWs> buscarFilmePorTitulo(@PathVariable String title) {
		TemplateRetornoWs filme = wsServiceBuscarFilmes.buscarFilmePorTitulo(title);
		return ResponseEntity.ok(filme);
	}
}

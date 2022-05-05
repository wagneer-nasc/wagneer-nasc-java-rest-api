package com.challengeinc.challenge.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challengeinc.challenge.models.TemplateRetornoWs;
import com.challengeinc.challenge.services.exceptions.ExcecaoDadosNaoEncontrado;

@Service
public class WsServiceBuscarFilmes {

	RestTemplate restTemplate = new RestTemplate();
	private String URL = "https://www.omdbapi.com/?apikey=7caa0414&";

	public TemplateRetornoWs buscarFilmePorTitulo(String titulo) {
		TemplateRetornoWs filme = restTemplate.getForObject(URL + "t=" + titulo, TemplateRetornoWs.class);

		if (!filme.isResponse()) {
			throw new ExcecaoDadosNaoEncontrado("Filme não encontrado no WS");
		}
		return filme;
	}

	public TemplateRetornoWs buscarFilmePorId(String id) {
		TemplateRetornoWs filme = restTemplate.getForObject(URL + "i=" + id, TemplateRetornoWs.class);

		if (!filme.isResponse()) {
			throw new ExcecaoDadosNaoEncontrado(
					"Filme não encontrado no WS, " + "Verifique os ids Corretos, ID Do ERROR: " + id);
		}
		return filme;
	}
}

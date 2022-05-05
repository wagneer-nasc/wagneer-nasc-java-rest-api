package com.challengeinc.challenge.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challengeinc.challenge.models.TemplateRetornoWs;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/ws/filmes", produces = { "application/json" })
@Tag(name = "Ws Buscar Filmes", description = " Ws Filmes IMDB")
public interface WsBuscarFilmesInterface {

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Filme encontrado :)", content = @Content(schema = @Schema(implementation = TemplateRetornoWs.class))),
			@ApiResponse(responseCode = "404", description = "Filmes não encontrado, verifique o titulo do filme") })
	@GetMapping
	public ResponseEntity<TemplateRetornoWs> buscarFilmePorTitulo(@PathVariable(required = true) String title);

}

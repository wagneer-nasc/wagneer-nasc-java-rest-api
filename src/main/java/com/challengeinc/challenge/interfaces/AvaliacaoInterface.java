package com.challengeinc.challenge.interfaces;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challengeinc.challenge.dto.AvaliacaoDTO;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag; 

@RequestMapping(value = "/avaliacoes", produces = { "application/json"})
@Tag(name = "Avaliações", description = "avaliações API")
public interface AvaliacaoInterface {

	@Operation(summary = "Adicionar avaliação", description = "Adicionar uma avaliação para um filme especifico", tags = {
			"avaliação" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", description = "Avaliacao criado", content = @Content(schema = @Schema(implementation = AvaliacaoDTO.class))),
			@ApiResponse(responseCode = "411", description = "Avalição não pode ser maior que 10 ou menor que 5"),
			@ApiResponse(responseCode = "400", description = "ID do filme invalido"),
			@ApiResponse(responseCode = "404", description = "Filme não encontrado") })
	@PostMapping("/{movie_id}")
	public ResponseEntity<AvaliacaoDTO> insert(
			 
			@ApiParam( value = "Id do filme que irá receber a avaliação", required = true, defaultValue = "2", example = "2", name = "id") String movie_id,
			@Valid @RequestBody AvaliacaoDTO avaliacaoDTO);

	@Operation(summary = "Remover avaliação", description = "Remover uma avaliação para um filme especifico", tags = {
			"avaliação" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Avaliacao removida"),
			@ApiResponse(responseCode = "404", description = "Avaliação não encontrada") })
	@DeleteMapping("/{avaliacao_id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) Long avaliacao_id);

	@Operation(summary = "Atualizar avaliação", description = "Atualizar uma avaliação de um filme especifico", tags = {
			"avaliação" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "411", description = "Avalição não pode ser maior que 10 ou menor que 5"),
			@ApiResponse(responseCode = "200", description = "Avaliacao atualizada", content = @Content(schema = @Schema(implementation = AvaliacaoDTO.class))),
			@ApiResponse(responseCode = "404", description = "Avaliação não encontrada") })
	@PutMapping
	public ResponseEntity<AvaliacaoDTO> update(@Valid @RequestBody AvaliacaoDTO avaliacaoDTO);
}

package com.challengeinc.challenge.interfaces;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challengeinc.challenge.dto.EstrelaDTO;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/estrelas", produces = { "application/json" })
@Tag(name = "Estrelas", description = "Estrelas API")
public interface EstrelaInterface {

	@Operation(summary = "Adicionar Estrela", description = "Adicionar uma Estrela para um filme especifico", tags = {
			"estrelas" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Estrela criada", content = @Content(schema = @Schema(implementation = EstrelaDTO.class))),
			@ApiResponse(responseCode = "411", description = "Estrela não pode ser maior que 5 ou menor que 1"),
			@ApiResponse(responseCode = "400", description = "ID do filme invalido"),
			@ApiResponse(responseCode = "404", description = "Filme não encontrado") })
	@PostMapping("/{filme_id}")
	public ResponseEntity<EstrelaDTO> insert(
			@ApiParam(value = "Id do filme que irá receber uma estrela", required = true) String movie_id,
			@Valid @RequestBody EstrelaDTO estrelaDTO);

	@Operation(summary = "Remover Estrela", description = "Remover uma Estrela para um filme especifico", tags = {
			"estrelas" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Estrela removida"),
			@ApiResponse(responseCode = "404", description = "Estrela não encontrada") })
	@DeleteMapping("/{estrela_id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) Long avaliacao_id);

	@Operation(summary = "Atualizar estrela", description = "Atualizar uma Estrela de um filme especifico", tags = {
			"avaliação" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "411", description = "Estrela não pode ser maior que 5 ou menor que 1"),
			@ApiResponse(responseCode = "200", description = "Estrela atualizada", content = @Content(schema = @Schema(implementation = EstrelaDTO.class))),
			@ApiResponse(responseCode = "404", description = "Estrela não encontrada") })
	@PutMapping
	public ResponseEntity<EstrelaDTO> update(@Valid @RequestBody EstrelaDTO estrelaDTO);
}

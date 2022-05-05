package com.challengeinc.challenge.interfaces;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challengeinc.challenge.dto.ComentarioDTO;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/comentarios")
@Tag(name = "Comentários", description = "Comentários API")
public interface ComentarioInterface {

	@Operation(summary = "Comentar um filme", description = "Adicionar um comentário para um filme especifico", tags = {
			"comentarios" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "comentário criado", content = @Content(schema = @Schema(implementation = ComentarioDTO.class))),
			@ApiResponse(responseCode = "406", description = "comentário não pode ser duplicado por filme"),
			@ApiResponse(responseCode = "400", description = "ID do filme invalido"),
			@ApiResponse(responseCode = "404", description = "Filme não encontrado") })
	@PostMapping("/{filme_id}")
	public ResponseEntity<ComentarioDTO> insert(
			@ApiParam(value = "Id do filme que irá receber um comentário", required = true) String movie_id,
			@Valid @RequestBody ComentarioDTO comentarioDTO);

	@Operation(summary = "Remover comentário", description = "Remover um comentário para um filme especifico", tags = {
			"comentários" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "comentário removido"),
			@ApiResponse(responseCode = "404", description = "comentário não encontrado") })
	@DeleteMapping("/{comentario_id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) Long comentario_id);

	@Operation(summary = "Atualizar comentário", description = "Atualizar um comentário de um filme especifico", tags = {
			"avaliação" })
	@ApiResponses(value = {
 			@ApiResponse(responseCode = "200", description = "comentário atualizado", content = @Content(schema = @Schema(implementation = ComentarioDTO.class))),
			@ApiResponse(responseCode = "404", description = "comentário não encontrado") })
	@PutMapping
	public ResponseEntity<ComentarioDTO> update(@Valid @RequestBody ComentarioDTO comentarioDTO);
}

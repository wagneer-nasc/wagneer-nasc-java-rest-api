package com.challengeinc.challenge.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.challengeinc.challenge.dto.DesejoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/desejos", produces = { "application/json" })
@Tag(name = "desejos", description = "desejos API")
public interface DesejoInterface {

	@Operation(summary = "Criar uma lista de desejo", description = "Criar uma lista de desejo de filmes", tags = {
			"desejos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "lista criada", content = @Content(schema = @Schema(implementation = DesejoDTO.class))),
			@ApiResponse(responseCode = "404", description = "Filme não encontrado") })
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<DesejoDTO> insert(@RequestBody DesejoDTO desejoDTO);

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "lista de desejos de filmes", content = @Content(schema = @Schema(implementation = DesejoDTO.class))),
			@ApiResponse(responseCode = "404", description = "Lista de desejo não encontrado") })
	@GetMapping
	public ResponseEntity<List<DesejoDTO>> findAll();

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "lista de um único desejo", content = @Content(schema = @Schema(implementation = DesejoDTO.class))),
			@ApiResponse(responseCode = "404", description = "Lista não encontrado , verificar o ID") })
	@GetMapping("/{desejo_id}")
	public ResponseEntity<List<DesejoDTO>> findOne(@PathVariable(required = true) Long desejo_id);

}

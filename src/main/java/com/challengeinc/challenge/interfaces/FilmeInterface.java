package com.challengeinc.challenge.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.challengeinc.challenge.dto.FilmeDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/filmes", produces = { "application/json" })
@Tag(name = "filmes", description = "Meus Filmes cadastrados API")
public interface FilmeInterface {

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "lista de filmes cadastrados", content = @Content(schema = @Schema(implementation = FilmeDTO.class))),
			@ApiResponse(responseCode = "404", description = "Lista de filmes não encontrado") })
	@GetMapping
	public ResponseEntity<List<FilmeDTO>> findAll();

}

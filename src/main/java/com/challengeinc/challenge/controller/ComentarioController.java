package com.challengeinc.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challengeinc.challenge.dto.ComentarioDTO;
import com.challengeinc.challenge.interfaces.ComentarioInterface;
import com.challengeinc.challenge.services.ComentarioService;

@RestController
public class ComentarioController implements ComentarioInterface {

	@Autowired
	private ComentarioService comentarioService;

	public ResponseEntity<ComentarioDTO> insert(@PathVariable String filme_id,
			@RequestBody ComentarioDTO comentarioDTO) {
		comentarioDTO = comentarioService.insertComentario(comentarioDTO, filme_id);
		return ResponseEntity.ok().body(comentarioDTO);
	}

	public ResponseEntity<Void> delete(@PathVariable Long comentario_id) {
		comentarioService.deleteComentario(comentario_id);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<ComentarioDTO> update(@RequestBody ComentarioDTO comentarioDTO) {
		comentarioDTO = comentarioService.updateComentario(comentarioDTO);
		return ResponseEntity.ok().body(comentarioDTO);
	}
}

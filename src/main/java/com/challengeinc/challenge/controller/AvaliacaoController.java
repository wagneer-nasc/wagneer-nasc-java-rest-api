package com.challengeinc.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challengeinc.challenge.dto.AvaliacaoDTO;
import com.challengeinc.challenge.interfaces.AvaliacaoInterface;
import com.challengeinc.challenge.services.AvaliacaoService;

@RestController
public class AvaliacaoController implements AvaliacaoInterface {

	@Autowired
	private AvaliacaoService avaliacaoService;

	public ResponseEntity<AvaliacaoDTO> insert(@PathVariable(required = true) String movie_id,
			@Valid @RequestBody AvaliacaoDTO avaliacaoDTO) {

		avaliacaoDTO = avaliacaoService.insertAvaliacao(avaliacaoDTO, movie_id);
		return ResponseEntity.ok().body(avaliacaoDTO);
	}

	public ResponseEntity<Void> delete(@PathVariable(required = true) Long avaliacao_id) {
		avaliacaoService.deleteAvaliacao(avaliacao_id);
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<AvaliacaoDTO> update(@RequestBody AvaliacaoDTO avaliacaoDTO) {
		avaliacaoDTO = avaliacaoService.updateAvaliacao(avaliacaoDTO);
		return ResponseEntity.ok().body(avaliacaoDTO);
	}
}

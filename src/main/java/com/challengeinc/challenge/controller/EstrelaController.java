package com.challengeinc.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challengeinc.challenge.dto.EstrelaDTO;
import com.challengeinc.challenge.interfaces.EstrelaInterface;
import com.challengeinc.challenge.services.EstrelaService;

@RestController
public class EstrelaController implements EstrelaInterface {

	@Autowired
	private EstrelaService estrelaService;

	public ResponseEntity<EstrelaDTO> insert(@PathVariable String filme_id, @RequestBody EstrelaDTO estrelaDTO) {
		estrelaDTO = estrelaService.insertEstrela(estrelaDTO, filme_id);
		return ResponseEntity.ok().body(estrelaDTO);
	}

	public ResponseEntity<Void> delete(@PathVariable Long estrela_id) {
		estrelaService.deleteEstrela(estrela_id);
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<EstrelaDTO> update(@RequestBody EstrelaDTO estrelaDTO) {
		estrelaDTO = estrelaService.updateEstrela(estrelaDTO);
		return ResponseEntity.ok().body(estrelaDTO);
	}
}

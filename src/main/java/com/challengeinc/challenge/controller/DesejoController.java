package com.challengeinc.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challengeinc.challenge.dto.DesejoDTO;
import com.challengeinc.challenge.interfaces.DesejoInterface;
import com.challengeinc.challenge.services.DesejoService;

@RestController
public class DesejoController implements DesejoInterface {

	@Autowired
	private DesejoService desejoService;

	public ResponseEntity<List<DesejoDTO>> findAll() {
		List<DesejoDTO> listDesejoDTO = desejoService.findAll();
		return ResponseEntity.ok().body(listDesejoDTO);
	}

	public ResponseEntity<List<DesejoDTO>> findOne(@PathVariable Long desejo_id) {
		List<DesejoDTO> listDesejoDTO = desejoService.findOne(desejo_id);
		return ResponseEntity.ok().body(listDesejoDTO);
	}

	public ResponseEntity<DesejoDTO> insert(@RequestBody DesejoDTO desejoDTO) {
		desejoDTO = desejoService.insert(desejoDTO);
		return ResponseEntity.ok().body(desejoDTO);
	}
}
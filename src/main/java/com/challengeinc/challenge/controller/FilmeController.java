package com.challengeinc.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengeinc.challenge.dto.FilmeDTO;
import com.challengeinc.challenge.interfaces.FilmeInterface;
import com.challengeinc.challenge.services.MovieService;

@RestController
public class FilmeController implements FilmeInterface{

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<FilmeDTO>> findAll() {
		List<FilmeDTO> listMovieDTO = movieService.findAll();
		return ResponseEntity.ok().body(listMovieDTO);
	}


}

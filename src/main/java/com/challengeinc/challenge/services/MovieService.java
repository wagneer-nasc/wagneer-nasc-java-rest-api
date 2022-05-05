package com.challengeinc.challenge.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengeinc.challenge.dto.FilmeDTO;
import com.challengeinc.challenge.models.Filme;
import com.challengeinc.challenge.repositories.FilmeRepository;

@Service
public class MovieService {

	@Autowired
	private FilmeRepository movieRepository;

	@Transactional(readOnly = true)
	public List<FilmeDTO> findAll() {
		List<Filme> listMovie = movieRepository.findAll();

		return listMovie.stream().map(item -> new FilmeDTO(item)).collect(Collectors.toList());

	}

}

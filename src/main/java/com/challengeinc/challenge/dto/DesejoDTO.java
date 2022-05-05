package com.challengeinc.challenge.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.challengeinc.challenge.models.Desejo;
import com.challengeinc.challenge.models.DesejoStatus;

public class DesejoDTO {
	private Long id;
	private String titulo;
	private DesejoStatus status;

	private List<FilmeDTO> filmes = new ArrayList<FilmeDTO>();

	public DesejoDTO() {

	}

	public DesejoDTO(Desejo entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		status = entity.getStatus();
		filmes = entity.getFilmes().stream()
				.map(item -> new FilmeDTO(item))
				.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public DesejoStatus getStatus() {
		return status;
	}

	public void setStatus(DesejoStatus status) {
		this.status = status;
	}

	public List<FilmeDTO> getFilmes() {
		return filmes;
	}

	@Override
	public String toString() {
		return "DesejoDTO [id=" + id + ", titulo=" + titulo + ", status=" + status + ", filmes=" + filmes + "]";
	}

	 
}

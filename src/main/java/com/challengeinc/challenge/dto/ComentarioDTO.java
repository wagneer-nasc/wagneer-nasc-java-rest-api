package com.challengeinc.challenge.dto;

import com.challengeinc.challenge.models.Comentario;

public class ComentarioDTO {
	private Long id;
	private String descricao;

	public ComentarioDTO(Comentario entity) {
		descricao = entity.getDescricao();
		id = entity.getId();
	}

	public ComentarioDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ComentarioDTO [id=" + id + ", descricao=" + descricao + "]";
	}

}

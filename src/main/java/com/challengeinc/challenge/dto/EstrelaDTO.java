package com.challengeinc.challenge.dto;

import com.challengeinc.challenge.models.Estrela;

public class EstrelaDTO {
	private Long id;
	private Long estrela;

	public EstrelaDTO(Estrela entity) {
		estrela = entity.getEstrela();
		id = entity.getId();
	}

	public EstrelaDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEstrela() {
		return estrela;
	}

	public void setEstrela(Long estrela) {
		this.estrela = estrela;
	}

	@Override
	public String toString() {
		return "EstrelaDTO [id=" + id + ", estrela=" + estrela + "]";
	}

}

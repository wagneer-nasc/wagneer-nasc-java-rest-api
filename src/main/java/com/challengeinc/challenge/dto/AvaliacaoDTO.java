package com.challengeinc.challenge.dto;

import com.challengeinc.challenge.models.Avaliacao;

public class AvaliacaoDTO {
	private Long id;
	private Long avaliacao;
	
	public AvaliacaoDTO(Avaliacao entity) {
		id = entity.getId();
		avaliacao = entity.getAvaliacao(); 
	}

	public AvaliacaoDTO() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Long avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "AvaliacaoDTO [id=" + id + ", avaliacao=" + avaliacao + "]";
	}
	
}

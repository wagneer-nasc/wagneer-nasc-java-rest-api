package com.challengeinc.challenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_avaliacao")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T01:12:13.118Z")

public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @JsonProperty("id")

 	private Long id;
	  @JsonProperty("avaliacao")

	private Long avaliacao;

	public Avaliacao() {

	}
	  @ApiModelProperty(example = "7422928", required = true, value = "2")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	  @ApiModelProperty(example = "7422928", required = true, value = "2")

	public Long getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Long avaliacao) {
		this.avaliacao = avaliacao;
	}

	 

}

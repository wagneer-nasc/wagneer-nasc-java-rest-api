package com.challengeinc.challenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estrela")
public class Estrela {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long id;
	private Long estrela;

	public Estrela() {

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
		return "Estrela [id=" + id + ", estrela=" + estrela + "]";
	}

}

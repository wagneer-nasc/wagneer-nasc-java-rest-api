package com.challengeinc.challenge.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_desejo")
public class Desejo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo; 
	private DesejoStatus status;
	
 	@ManyToMany
 	@JoinTable(name = "tb_desejo_filme", 
	joinColumns = @JoinColumn(name = "desejo_id"), 
	inverseJoinColumns = @JoinColumn(name = "filme_id"))
	private Set<Filme> filmes = new HashSet<Filme>(); 
 	
	public Desejo() {

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
 
	 public Set<Filme> getFilmes() {
		return filmes;
	}

	@Override
	public String toString() {
		return "Desejo [id=" + id + ", titulo=" + titulo + ", status=" + status + ", filmes=" + filmes + "]";
	} 
	
 
}

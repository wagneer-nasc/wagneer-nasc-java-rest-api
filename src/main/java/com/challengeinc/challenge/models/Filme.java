package com.challengeinc.challenge.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tb_filme")
public class Filme {
	@Id
	private String id_filme;
	private String titulo;

	private String ano_lancamento;

	private String liberado;

	private String genero;

	private String diretor;

	private String escritor;

	private String atores;

	private String enredo;

	private String lingua;

	private String pais;

	private String premios;

	private String image_cartaz;

	private String tipo;

	private String producao;
	 
	@ManyToMany 
	@JoinTable(name = "tb_filme_comentario",
	joinColumns = @JoinColumn(name = "filme_id"), 
	inverseJoinColumns = @JoinColumn(name = "comentario_id"))
	private Set<Comentario> comentarios = new HashSet<Comentario>();
	 
	@ManyToMany 
	@JoinTable(name = "tb_filme_avaliacao", 
	joinColumns = @JoinColumn(name = "filme_id"), 
	inverseJoinColumns = @JoinColumn(name = "avaliacao_id"))
	private Set<Avaliacao> avaliacoes = new HashSet<Avaliacao>();
	  
	@ManyToMany 
	@JoinTable(name = "tb_filme_estrela", 
	joinColumns = @JoinColumn(name = "filme_id"), 
	inverseJoinColumns = @JoinColumn(name = "estrela_id"))
	private Set<Estrela> estrelas = new HashSet<Estrela>();
	  
	public Filme() {
		
	}
 
	
	public String getId_filme() {
		return id_filme;
	}


	public void setId_filme(String id_filme) {
		this.id_filme = id_filme;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAno_lancamento() {
		return ano_lancamento;
	}


	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}


	public String getLiberado() {
		return liberado;
	}


	public void setLiberado(String liberado) {
		this.liberado = liberado;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getDiretor() {
		return diretor;
	}


	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}


	public String getEscritor() {
		return escritor;
	}


	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}


	public String getAtores() {
		return atores;
	}


	public void setAtores(String atores) {
		this.atores = atores;
	}


	public String getEnredo() {
		return enredo;
	}


	public void setEnredo(String enredo) {
		this.enredo = enredo;
	}


	public String getLingua() {
		return lingua;
	}


	public void setLingua(String lingua) {
		this.lingua = lingua;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getPremios() {
		return premios;
	}


	public void setPremios(String premios) {
		this.premios = premios;
	}


	public String getImage_cartaz() {
		return image_cartaz;
	}


	public void setImage_cartaz(String image_cartaz) {
		this.image_cartaz = image_cartaz;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getProducao() {
		return producao;
	}


	public void setProducao(String producao) {
		this.producao = producao;
	}


	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public Set<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public Set<Estrela> getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(Set<Estrela> estrelas) {
		this.estrelas = estrelas;
	}

	@Override
	public String toString() {
		return "Movie [id_filme=" + id_filme + ", titulo=" + titulo + ", ano_lancamento=" + ano_lancamento
				+ ", liberado=" + liberado + ", genero=" + genero + ", diretor=" + diretor + ", escritor=" + escritor
				+ ", atores=" + atores + ", enredo=" + enredo + ", lingua=" + lingua + ", pais=" + pais + ", premios="
				+ premios + ", image_cartaz=" + image_cartaz + ", tipo=" + tipo + ", producao=" + producao
				+ ", comentarios=" + comentarios + ", avaliacoes=" + avaliacoes +  ", estrelas=" + estrelas +"]";
	}
 

}

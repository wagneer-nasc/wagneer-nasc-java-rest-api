package com.challengeinc.challenge.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.challengeinc.challenge.models.Filme;

public class FilmeDTO {
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

	private List<ComentarioDTO> comentarios = new ArrayList<ComentarioDTO>();
	private List<AvaliacaoDTO> avaliacoes = new ArrayList<AvaliacaoDTO>();
	private List<EstrelaDTO> estrelas = new ArrayList<EstrelaDTO>();

	
	public FilmeDTO(Filme entity) {
		id_filme = entity.getId_filme();
		titulo = entity.getTitulo();
		ano_lancamento = entity.getAno_lancamento();
		liberado = entity.getLiberado();
		genero = entity.getGenero();
		diretor = entity.getDiretor();
		escritor = entity.getEscritor();
		atores = entity.getAtores();
		enredo = entity.getEnredo();
		lingua = entity.getLingua();
		pais = entity.getPais();
		premios = entity.getPremios();
		image_cartaz = entity.getImage_cartaz();
		tipo = entity.getTipo();
		producao = entity.getProducao();
	 	comentarios = entity.getComentarios().stream()
				.map(item -> new ComentarioDTO(item))
				.collect(Collectors.toList());
		avaliacoes = entity.getAvaliacoes().stream()
				.map(item -> new AvaliacaoDTO(item))
				.collect(Collectors.toList()); 
		estrelas = entity.getEstrelas().stream()
				.map(item -> new EstrelaDTO(item))
				.collect(Collectors.toList()); 
	}

	public FilmeDTO() {

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

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}

	public void setAvaliacoes(List<AvaliacaoDTO> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public List<AvaliacaoDTO> getAvaliacoes() {
		return avaliacoes;
	}

	public List<EstrelaDTO> getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(List<EstrelaDTO> estrelas) {
		this.estrelas = estrelas;
	}

	@Override
	public String toString() {
		return "MovieDTO [id_filme=" + id_filme + ", titulo=" + titulo + ", ano_lancamento=" + ano_lancamento
				+ ", liberado=" + liberado + ", genero=" + genero + ", diretor=" + diretor + ", escritor=" + escritor
				+ ", atores=" + atores + ", enredo=" + enredo + ", lingua=" + lingua + ", pais=" + pais + ", premios="
				+ premios + ", image_cartaz=" + image_cartaz + ", tipo=" + tipo + ", producao=" + producao
				+ ", comentarios=" + comentarios + ", avaliacoes=" + avaliacoes + ", estrelas=" + estrelas + "]";
	}

}

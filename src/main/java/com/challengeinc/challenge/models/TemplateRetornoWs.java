package com.challengeinc.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateRetornoWs {
	@JsonProperty("Title")
	private String title;

	@JsonProperty("Year")
	private String year;

	@JsonProperty("Released")
	private String released;

	@JsonProperty("Genre")
	private String genre;

	@JsonProperty("Director")
	private String director;

	@JsonProperty("Writer")
	private String writer;

	@JsonProperty("Actors")
	private String actors;

	@JsonProperty("Plot")
	private String plot;

	@JsonProperty("Language")
	private String language;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Awards")
	private String awards;

	@JsonProperty("Poster")
	private String poster;

	@JsonProperty("imdbID")
	private String imdbID;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Production")
	private String production;

	@JsonProperty("Response")
	private boolean response;

	public TemplateRetornoWs() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "FilmeWs [title=" + title + ", year=" + year + ", released=" + released + ", genre=" + genre
				+ ", director=" + director + ", writer=" + writer + ", actors=" + actors + ", plot=" + plot
				+ ", language=" + language + ", country=" + country + ", awards=" + awards + ", poster=" + poster
				+ ", imdbID=" + imdbID + ", type=" + type + ", production=" + production + ", response=" + response
				+ "]";
	}
}
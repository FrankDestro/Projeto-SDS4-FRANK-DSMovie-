package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.Movie;


public class MovieDTO {
	
	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	private String synopsis; 
	private Integer year;
	
	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, Double score, Integer count, String image, String synopsis, Integer year) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
		this.synopsis = synopsis;
		this.year = year;
	}
	
	// Criando um construtor que recebe um objeto Movie (com todos os atributos) e faco um get do objeto Movie e armazeno em um objeto DTO. 
	public MovieDTO(Movie movie) {
		id = movie.getId();
		title = movie.getTitle();
		score = movie.getScore();
		count = movie.getCount();
		image = movie.getImage();
		synopsis = movie.getSynopsis();
		year = movie.getYear();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}

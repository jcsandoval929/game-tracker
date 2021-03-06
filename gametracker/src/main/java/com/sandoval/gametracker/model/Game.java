package com.sandoval.gametracker.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Game implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String title;
	@Column(name="description", columnDefinition="TEXT", length=1000)
	private String description;
	private String genre;
	private String developer;
	private Boolean completed;
	private Boolean wanted;
	private String imageUrl;

	public Game() {
	}

	public Game(Long id, String title, String description, String genre, String developer, Boolean completed,
			Boolean wanted, String imageUrl) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.developer = developer;
		this.completed = completed;
		this.wanted = wanted;
		this.imageUrl = imageUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Boolean getWanted() {
		return wanted;
	}

	public void setWanted(Boolean wanted) {
		this.wanted = wanted;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Game{" + "id=" + id + "title='" + title + '\'' + "description='" + description + '\'' + "genre='"
				+ genre + '\'' + "developer='" + developer + '\'' + "completed='" + completed + '\'' + "wanted='"
				+ wanted + '\'' + "imageUrl='" + imageUrl + '\'' + '}';
	}

}

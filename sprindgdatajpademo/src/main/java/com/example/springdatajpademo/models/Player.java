package com.example.springdatajpademo.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
	
	@Id
	private UUID id; 
	
	@Column(name="name")
	private String name;
	
	@Column(name="country")
	private String country;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="club")
	private String club;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", country=" + country + ", rating=" + rating + ", club=" + club
				+ "]";
	}
	
	
	

}

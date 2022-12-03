package com.org.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "MOVIE_REPO")
public class Movie implements Serializable {
	
	@Id
	@Column(name = "MID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	@NonNull
	@Column(name = "NAME", length = 20)
	private String mname;
	@NonNull
	@Column(name = "YEAR", length = 20)
	private String year;
	@NonNull
	@Column(name ="RATING")
	private Float rating;
}

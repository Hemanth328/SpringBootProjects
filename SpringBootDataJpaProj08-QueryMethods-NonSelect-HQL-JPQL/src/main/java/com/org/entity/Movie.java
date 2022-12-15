package com.org.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@DynamicInsert(true)
@Table(name = "MOVIE_REPO")
public class Movie implements Serializable {
	
	
	// Din't use this property any where
	private static final long serialVersionUID = 1L;
	
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
//	@Transient   // --> If we annotate a property with this annotation then this property will not involve in persistence operation
	private Float rating;
}

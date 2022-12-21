package com.org.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="person_info_lob")
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfo implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length = 20)
	private String pname;
	private LocalDateTime dob;
	private boolean married;
	
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
}

package com.org.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	@Nonnull
	private Integer empno;
	private String ename;
	private String desg;
	private Float sal;
	private Integer deptno;
}

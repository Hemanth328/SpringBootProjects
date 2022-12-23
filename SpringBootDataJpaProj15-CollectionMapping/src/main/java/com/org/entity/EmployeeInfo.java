package com.org.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "EMPLOYEE_COLLECTION_INFO")
public class EmployeeInfo {
	@Id
	@GeneratedValue
	private Integer eid;
	
	@Column(length = 20)
	private String ename;
	
	@ElementCollection // Takes the element values of given collection property and inserts them in child db table as col values
	@JoinTable(name="EMPLOYEE_FRIENDS") // To specify child table name
	@JoinColumn(name="EMP_ID", referencedColumnName = "EID") // To specify FK Column name of child table linked with PK Column of parent db table
	@OrderColumn(name="FRIEND_INDEX") // To specify Index column while working with List Collection
	@ListIndexBase(value =1) // To specify the start/base value of index
	@Column(name="FRIEND_NAME", length = 20)
	private List<String> friends;
	
	@ElementCollection
	@JoinTable(name="EMPLOYEE_ID_DETAILS")
	@JoinColumn(name = "EMP_ID", referencedColumnName="EID")
	@Column(name="PHONE_NUMBER", length = 11)
	private Set<Long> phoneNumbers;
	
	@ElementCollection
	@JoinTable(name="EMPLOYEE_ID_DETAILS")
	@JoinColumn(name = "EMP_ID", referencedColumnName="EID")
	@Column(name="PHONE_NUMBER", length = 11)
	private Map<String, String> idDeatils;
	

}

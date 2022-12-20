package com.org.service;

import java.util.List;

import com.org.entity.Employee;

public interface IEmployeeManagementService {
	List<Employee> fetchEmployeeDetailsByDesg(String desg1, String desg2);
}

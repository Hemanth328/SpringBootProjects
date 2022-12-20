package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("empservice")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	private EntityManager manager;
	
	
	@Override
	public List<Employee> fetchEmployeeDetailsByDesg(String desg1, String desg2) {
		//Create StoredProcedureQuery Object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_EMPS_BY_JOB", Employee.class);
		
		// Register parameters with JDBC Types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		
		//Set Values to IN Params
		query.setParameter(1, desg1);
		query.setParameter(2, desg2);
		
		// call the PL/SQL and get the Result
		
		List<Employee> list = query.getResultList();
		return list;
		
	}

}

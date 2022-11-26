package com.org.service;

import com.org.dao.IEmployeeDAO;
import com.org.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employee")
public class EmployeeManagementServiceImpl implements IEmployeeMgmtService{

    @Autowired
    private IEmployeeDAO dao;
    
    public EmployeeManagementServiceImpl() {
		System.out.println("EmployeeManagementServiceImpl : 0-param Constructor");
	}

	@Override
    public List<Employee> fetchEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
        List<Employee> list = dao.getEmployeeByDesignation(desg1, desg2, desg3);
        return list;
    }
}

package com.org.dao;

import com.org.model.Employee;

import java.util.List;


public interface IEmployeeDAO {

    List<Employee> getEmployeeByDesignation(String desg1, String desg2, String desg3) throws Exception;
}

package com.org.service;


import com.org.model.Employee;

import java.util.List;

public interface IEmployeeMgmtService {
    public List<Employee> fetchEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception;
}

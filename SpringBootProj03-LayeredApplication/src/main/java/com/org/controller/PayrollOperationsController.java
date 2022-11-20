package com.org.controller;

import com.org.model.Employee;
import com.org.service.IEmployeeMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("payroll")
public class PayrollOperationsController {
    @Autowired
    private IEmployeeMgmtService service;

    public List<Employee> showAllEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
        List<Employee> list = service.fetchEmployeeByDesg(desg1, desg2, desg3);
        return list;
    }
}

package com.org.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.service.EmployeeManagementServiceImpl;


/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_EMPS_BY_JOB`(IN job1 varchar(20),
									  IN job2 varchar(20))
BEGIN
  select * from employee where desg in(job1, job2) order by desg;
END
 */

@Component
public class PLSQLProceduresMysqlTestRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeManagementServiceImpl service;

	@Override
	public void run(String... args) throws Exception {
		
		service.fetchEmployeeDetailsByDesg("SALESMAN", "MANAGER").forEach(emp -> {
			System.out.println(emp);
		});
	}

}

package com.org.dao;

import com.org.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("employeedao")
public class EmployeeDAOImpl implements IEmployeeDAO{

    private static final String GET_EMP_BY_DESG = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";

    @Autowired
    private DataSource dataSource;


    @Override
    public List<Employee> getEmployeeByDesignation(String desg1, String desg2, String desg3) throws Exception {

    	System.out.println("Datasource class name "+dataSource.getClass());
    	
        List<Employee> list = null;
        try(Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_EMP_BY_DESG)){

            if(ps != null){
                ps.setString(1, desg1);
                ps.setString(2, desg2);
                ps.setString(3, desg3);
            }

            try(ResultSet rs = ps.executeQuery()){

                list = new ArrayList<Employee>();
                while (rs.next()){
                    Employee emp = new Employee();
                    emp.setEno(rs.getInt(1));
                    emp.setEname(rs.getString(2));
                    emp.setDesg(rs.getString(3));
                    emp.setSalary(rs.getDouble(4));
                    emp.setDeptno(rs.getInt(5));
                    list.add(emp);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}

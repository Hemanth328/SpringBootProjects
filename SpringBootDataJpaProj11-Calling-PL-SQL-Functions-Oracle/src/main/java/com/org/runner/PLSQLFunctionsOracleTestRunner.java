package com.org.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import oracle.jdbc.OracleTypes;


/*
 * 
CREATE OR REPLACE FUNCTION FX_GET_MOVIES_BY_RATING 
(
  STARTRATING IN VARCHAR2 
, ENDRATING IN VARCHAR2 
, CNT OUT NUMBER   -----> Return type
) RETURN SYS_REFCURSOR AS 
  details SYS_REFCURSOR;  // Local variable
BEGIN
  SELECT COUNT(*) INTO CNT FROM MOVIE_REPO;  // this result goes to out parameter
  
  OPEN DETAILS FOR                                                                                |  Select query results are going to cursor variable             
      SELECT NAME, RATING, YEAR FROM MOVIE_REPO WHERE RATING>=STARTRATING AND RATING<=ENDRATING;  |
  
  RETURN DETAILS;  // Returning local variables, satisfying the return type of PL/SQL function
END FX_GET_MOVIES_BY_RATING;
 */
@Component
public class PLSQLFunctionsOracleTestRunner implements CommandLineRunner {
	/*
		@Autowired
		private MovieRepo movieRepo;
		*/
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		// Unwrap Session Object from EntityManager Object
		Session session = entityManager.unwrap(Session.class);
		
		// Work with ReturningWork<T> callback interface based callback method
		Object results[] = session.doReturningWork( con -> {  //If an interface is functional Interface then we can implement by using Lambda expression
			// Write Callback Statement based logic to call PL/SQL function
			CallableStatement cs = con.prepareCall("{?=call FX_GET_MOVIES_BY_RATING(?,?,?)}");
			
			//register return, out params(4) with jdbc types
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.registerOutParameter(4, Types.INTEGER);
			
			// set values to IN Parameter
			cs.setFloat(2, 3.0f);
			cs.setFloat(3, 4.5f);
			
			// call PL/SQL Function
			cs.execute();
			
			//gather results from out parameters
			ResultSet rs = (ResultSet)cs.getObject(1);  // return value
			
			List<Object[]> list = new ArrayList<Object[]>();
			while(rs.next()) {
				Object record[] = new Object[3];
				record[0] = rs.getString(1);
				record[1] = rs.getString(2);
				record[2] = rs.getString(3);
				
				list.add(record);
			}
			
			Object data[] = new Object[2];
			data[0] = list;
			data[1] = cs.getInt(4); // Out param cnt Value
			
			return data;
			
		});
		
		//Process the result[]
		System.out.println("Movies in rating are ::");
		List<Object[]> ratingsList = (List<Object[]>) results[0];
		ratingsList.forEach( md -> {
			for(Object val : md) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});
		
		//get count of records
		int count = (int)results[1];
		System.out.println("records count :: "+count);
		
	}
}

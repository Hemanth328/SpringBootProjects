package com.org.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

/*
CREATE OR REPLACE PROCEDURE P_GET_MOVIES_BY_YEAR_RANGE 
(
  STARTYEAR IN VARCHAR2 
, ENDYEAR IN VARCHAR2 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  open details for
      SELECT MID, NAME, RATING, YEAR FROM MOVIE_REPO WHERE YEAR>=STARTYEAR AND YEAR<=ENDYEAR;
END P_GET_MOVIES_BY_YEAR_RANGE;
		  
*/
@Component
public class PLSQLProcedureOracleTestRunner implements CommandLineRunner {
	/*
		@Autowired
		private MovieRepo movieRepo;
		*/
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void run(String... args) throws Exception {
		// create stored procedure query object representing the given pl/sql procedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("P_GET_MOVIES_BY_YEAR_RANGE", Movie.class);
		
		//Register parameters of PL/SQL Procedurs with jdbc/java types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Movie.class, ParameterMode.REF_CURSOR);
		
		// Set values to IN Parameters
		query.setParameter(1, "2000");
		query.setParameter(2, "2020");
		
		// call PL/SQL Procedure and get the results
		
		/*List<Movie> list = query.getResultList();  // Instead of writing in two lines writing in one line
		list.forEach(System.out::println);*/
		
		query.getResultList().forEach(System.out::println);
		
		System.out.println("\n=========================================================================\n");
		
		/*
		 * Since this record is not expecting any record from any db table for displaying, we can ignore model class development and 
		 * repository interface
		 */
		// create stored procedure query object representing the given pl/sql procedure
		StoredProcedureQuery query1 = entityManager.createStoredProcedureQuery("PRO_AUTHENTICATION");
		
		//Registering parameters of PL/SQL Procedures with Java/JDBC types
		query1.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query1.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query1.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		
		// Set values to IN Params
		query1.setParameter(1, "Hemanth");
		query1.setParameter(2, "Hemanth");
		
		//Call PL/SQL Procedure
		String result = (String)query1.getOutputParameterValue(3);  // Return type is object so we are type casting to String 
		System.out.println("Authentication Result  "+result);
	} 
}

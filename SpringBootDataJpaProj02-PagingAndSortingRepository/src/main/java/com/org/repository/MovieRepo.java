package com.org.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.org.entity.Movie;


public interface MovieRepo extends PagingAndSortingRepository<Movie, Integer>, ListCrudRepository<Movie, Integer> {
  /*
   * From Spring 3.0 PagingAndSortingRepository no more extends from crudRepository
   * 
   * 
   * Spring 2.0
   * ===========
   * 
   * public interface PersonRepository<Person, Long> extends PagingAndSortingRepository<Person, Long> {}
   * 
   * Spring 3.0
   * ==========
   * 
   * public interface PersonRepository<Person, Long> extends PagingAndSortingRepository<Person, Long>, ListCrudRepository<Person, Long> {}
   */
}

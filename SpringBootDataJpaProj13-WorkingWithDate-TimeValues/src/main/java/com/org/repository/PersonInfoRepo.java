package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.PersonInfo;

@Repository("personRepo")
public interface PersonInfoRepo extends JpaRepository<PersonInfo, Integer> {

}

package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	List<Person> findByName(String name);
	
	Person findById(long id);
}

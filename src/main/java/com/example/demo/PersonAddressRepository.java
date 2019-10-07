package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long>{

	List<PersonAddress> findByStreet(String street);
}

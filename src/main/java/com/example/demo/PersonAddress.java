package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Data
@Entity
public class PersonAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String street;
	
	
	public PersonAddress() {}
	
	@OneToOne(mappedBy="address")
	@JsonBackReference
	private Person person;
	
}

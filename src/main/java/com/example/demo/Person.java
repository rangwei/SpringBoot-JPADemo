package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	public Person() {}
	
	public Person(String name) {
		this.name = name;
	}
	
	@OneToOne
	@JsonManagedReference
	private PersonAddress address;
}

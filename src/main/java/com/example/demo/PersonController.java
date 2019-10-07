package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	private PersonRepository pr;

	public PersonController(PersonRepository pr) {
		this.pr = pr;
	}

	@GetMapping("/people")
	List<Person> all() {
		return pr.findAll();
	}

	@GetMapping("/people/{id}")
	Person one(@PathVariable Long id) {

		return pr.findById(id).orElseThrow(() -> new RuntimeException());
	}

}

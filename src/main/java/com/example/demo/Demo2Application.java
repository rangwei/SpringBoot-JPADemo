package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (PersonRepository pr, PersonAddressRepository par) {
		return (args) -> {
			Person p = new Person("jacky");
			PersonAddress pa = new PersonAddress();
			pa.setStreet("street");
			
			pa = par.save(pa);
			
			p.setAddress(pa);
			pr.save(p);
			
			
			p = new Person("andy");
			pa = new PersonAddress();
			pa.setStreet("street 2");
			
			pa = par.save(pa);
			
			p.setAddress(pa);
			pr.save(p);
			
			
			
		};
		
	}

}

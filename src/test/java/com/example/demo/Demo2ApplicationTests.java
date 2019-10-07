package com.example.demo;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private PersonAddressRepository addressRepo;

	@Test
	public void contextLoads() {
		
		//save 2 person
		Person p1 = new Person("aa");
		Person p2 = new Person("bb");
		
		personRepo.save(p1);
		personRepo.save(p2);
		
		//find person by name
		List<Person> list = personRepo.findByName("aa");
		int size = list.size();
		assertEquals(1, size);
		
		Person p = list.get(0);
		assertEquals("aa", p.getName());
		
		
		//save person with address
		PersonAddress pa3 = new PersonAddress();
		pa3.setStreet("street123");
		pa3 = addressRepo.save(pa3);
		
		Person p3 = new Person("cc");
		p3.setAddress(pa3);
		personRepo.save(p3);
		
		list = personRepo.findByName("cc");
		p = list.get(0);
		
		PersonAddress addr = p.getAddress();
		assertEquals("street123", addr.getStreet());
		
		
		//find address
		List<PersonAddress> addrList = addressRepo.findByStreet("street123");
		size = addrList.size();
		assertEquals(1, size);
		
		PersonAddress addr123 = addrList.get(0);
		Person p123 = addr123.getPerson();
		
		assertEquals("cc", p123.getName());
		
	}

}

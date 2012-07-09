package com.proquest.interview.phonebook;

import java.util.List;

public interface PhoneBookService {
	
	public Person findPerson(String firstName, String lastName);
	
	public void addPerson(Person newPerson);
	
	public List<Person> getAllPeople();

}

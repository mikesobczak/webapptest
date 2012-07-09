package com.proquest.interview.phonebook;

import java.util.List;

public interface PhoneBookDao {
	
	public void create(Person person);
	
	public List<Person> getByName(String name);
	
	public List<Person> getAllPeople();

}

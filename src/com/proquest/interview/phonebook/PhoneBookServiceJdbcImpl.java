package com.proquest.interview.phonebook;

import java.util.List;

public class PhoneBookServiceJdbcImpl implements PhoneBookService {

	private PhoneBookDao phoneBookDao = null;
	
	public void addPerson(Person newPerson) {
		phoneBookDao.create(newPerson);
	}
	
	public Person findPerson(String firstName, String lastName) {
		List<Person> people = phoneBookDao.getByName( firstName + " " + lastName );
		
		return people.get(0);
	}
	
	public List<Person> getAllPeople()
	{
		return phoneBookDao.getAllPeople();
	}

	public PhoneBookDao getPhoneBookDao() {
		return phoneBookDao;
	}

	public void setPhoneBookDao(PhoneBookDao phoneBookDao) {
		this.phoneBookDao = phoneBookDao;
	}
	
}

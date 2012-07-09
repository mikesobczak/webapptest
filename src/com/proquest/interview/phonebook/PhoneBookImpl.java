package com.proquest.interview.phonebook;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookImpl implements PhoneBook {
	public List people;
	
	public Person findPerson(String firstName, String lastName){
		// 2012-07-09 msobczak: see PhoneBookService.findPerson()
		return new Person();
	};
	public void addPerson(Person newPerson){
		// 2012-07-09 msobczak: see PhoneBookService.addPerson()
	};
	
	public static void main(String[] args) {
		DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("application.xml");
		
		PhoneBookService pbs = (PhoneBookService)factory.getBean("phoneBookService");

		/* TODO: create person objects and put them in the PhoneBook and database
		 * John Smith, (248) 123-4567, 1234 Sand Hill Dr, Royal Oak, MI
		 * Cynthia Smith, (824) 128-8758, 875 Main St, Ann Arbor, MI
		*/ 
		Person newPerson = new Person();
		newPerson.name = "John Smith";
		newPerson.phoneNumber = "(248) 123-4567";
		newPerson.address = "1234 Sand Hill Dr, Royal Oak, MI";
		pbs.addPerson(newPerson);
		
		newPerson.name = "Cynthia Smith";
		newPerson.phoneNumber = "(824) 128-8758";
		newPerson.address = "875 Main St, Ann Arbor, MI";
		pbs.addPerson(newPerson);
		
		// TODO: print the phone book out to System.out
		List<Person> people = pbs.getAllPeople();
		
		System.out.println ( "Contents of Phone Book:");
		
		Iterator iter = people.iterator();
		while (iter.hasNext())
		{
			Person customer = (Person)iter.next();
			System.out.println ( customer );
		}
		
		// TODO: find Cynthia Smith and print out just her entry
		System.out.println ( "Search results for Cynthia Smith:");
		Person person = pbs.findPerson("Cynthia", "Smith");
		System.out.println ( person );
		
		// TODO: insert the new person objects into the database
		newPerson.name = "Michael Sobczak";
		newPerson.phoneNumber = "(734) 762-1693";
		newPerson.address = "33442 Orangelawn, Livonia, MI";
		pbs.addPerson(newPerson);
	}
}

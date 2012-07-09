package com.proquest.interview.phonebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PhoneBookDaoJdbcImpl implements PhoneBookDao {
	
	private static final String INSERT_PERSON_SQL = "INSERT INTO PHONEBOOK (NAME, PHONENUMBER, ADDRESS) VALUES(?, ?, ?)";
	private static final String SELECT_BY_PERSON_NAME_SQL = "SELECT * FROM PHONEBOOK WHERE NAME = ?";
	
	private JdbcTemplate template;
	
	public void setJdbcTemplate(JdbcTemplate template) 
	{
		this.template = template;
	}
	
	public void create(Person person) {
		Object[] params = new Object[] {
				person.name,
				person.address, 
				person.phoneNumber}; 

		template.update(INSERT_PERSON_SQL, params);

	}
	
	public List<Person> getByName(String name) {
		return template.query(SELECT_BY_PERSON_NAME_SQL, 
				new Object[] {name}, new PhoneBookRowMapper());
	}
	
	public List<Person> getAllPeople() {
		return template.query("SELECT * FROM PHONEBOOK",(Object[])null, new PhoneBookRowMapper());
	}
	
	private static class PhoneBookRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			String name = rs.getString(1);
			String phoneNumber = rs.getString(2);
			String address = rs.getString(3);
			
			Person person = new Person();
			person.name = name;
			person.phoneNumber = phoneNumber;
			person.address = address;
			return person;
		}
	}

}

package com.rabbit.mdb.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.mdb.dao.PersonDAO;
import com.rabbit.mdb.dao.PersonNotFoundException;
import com.rabbit.mdb.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	private Map<Long, Person> dbMap = new HashMap<>();
	{
		dbMap.put(1L, Person.of(1, "Tom", "US"));
		dbMap.put(2L, Person.of(2, "One", "India"));
		dbMap.put(3L, Person.of(3, "Three", "India"));
		dbMap.put(4L, Person.of(4, "Four", "India"));
		dbMap.put(5L, Person.of(5, "Five", "India"));
				
	}
	public Person getById(long id) throws PersonNotFoundException, SQLException {
		return this.personDAO.getById(id);
		// return dbMap.get(id);
	}

	public List<Person> listAll() throws SQLException {
		return this.personDAO.listAll();
	}
	
	public List<Person> listAllFromCache() throws SQLException {
		return dbMap.values().stream().collect(Collectors.toList());
	}
}

package com.rabbit.mdb.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		for (int ix = 0; ix < 10; ix++) {
			dbMap.put((long)ix, Person.of(ix, "Tom" + ix, "US"));
		}
	}
	public Person getById(long id) throws PersonNotFoundException, SQLException {
		return this.personDAO.getById(id);
		// return dbMap.get(id);
	}

	public List<Person> listAll() throws SQLException {
		return this.personDAO.listAll();
	}
	
	public Collection<Person> listAllFromCache() throws SQLException {
		return dbMap.values();
	}
}

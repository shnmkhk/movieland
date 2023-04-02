package com.rabbit.mdb.service;

import java.sql.SQLException;
import java.util.List;

import com.rabbit.mdb.dao.PersonNotFoundException;
import com.rabbit.mdb.model.Person;

public interface PersonService {

	Person getById(final long id) throws PersonNotFoundException, SQLException;

	List<Person> listAll() throws SQLException;
	
	public List<Person> listAllFromCache() throws SQLException;
}

package com.rabbit.mdb.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.rabbit.mdb.dao.PersonNotFoundException;
import com.rabbit.mdb.model.Person;

public interface PersonService {

	Person getById(final long id) throws PersonNotFoundException, SQLException;

	List<Person> listAll() throws SQLException;

	public Collection<Person> listAllFromCache() throws SQLException;
}

package com.rabbit.mdb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.mdb.dao.PersonDAO;
import com.rabbit.mdb.dao.PersonNotFoundException;
import com.rabbit.mdb.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	public Person getById(long id) throws PersonNotFoundException, SQLException {
		return this.personDAO.getById(id);
	}

	public List<Person> listAll() throws SQLException {
		return this.personDAO.listAll();
	}
}

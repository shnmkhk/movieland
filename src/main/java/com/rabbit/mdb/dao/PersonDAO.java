package com.rabbit.mdb.dao;

import java.sql.SQLException;
import java.util.List;

import com.rabbit.mdb.model.Person;

public interface PersonDAO {

	Person getById(final long id) throws PersonNotFoundException, SQLException;

	List<Person> listAll() throws SQLException;
}

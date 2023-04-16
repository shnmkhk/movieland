package com.rabbit.mdb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rabbit.mdb.dao.PersonDAO;
import com.rabbit.mdb.dao.PersonNotFoundException;
import com.rabbit.mdb.model.Person;

@Repository
public class PersonDAOImpl extends BaseDAOImpl implements PersonDAO {

	@Override
	public Person getById(long id) throws PersonNotFoundException, SQLException {
		try (Connection conn = dataSource().getConnection();
				Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = statement
						.executeQuery(String.format("select id, name, address from person where id=%d", id))) {
			if (!rs.next())
				return null;
			return new Person(rs.getLong("ID"), rs.getString("NAME"), rs.getString("ADDRESS"));
		} finally {
		}
	}

	@Override
	public List<Person> listAll() throws SQLException {
		List<Person> allList = new ArrayList<>();
		try (Connection conn = dataSource().getConnection();
				Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = statement.executeQuery(String.format("select id, name, address from person"))) {
			while (rs.next())
				allList.add(new Person(rs.getLong("ID"), rs.getString("NAME"), rs.getString("ADDRESS")));
		} finally {
		}
		return allList;
	}

}

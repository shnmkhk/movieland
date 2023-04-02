package com.rabbit.mdb;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rabbit.mdb.dao.PersonNotFoundException;
import com.rabbit.mdb.model.Person;
import com.rabbit.mdb.service.PersonService;

@Controller
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(path = "/{id}", produces = {"application/json"})
	@ResponseBody
	public Person getById(@PathVariable("id") final long id) throws PersonNotFoundException, SQLException {
		System.out.println("in getById method");
		return personService.getById(id);
	}
	@GetMapping(produces = {"application/json"})
	@ResponseBody
	public List<Person> getAll() throws SQLException {
		return personService.listAll();
	}
	
	@GetMapping(path = "/cache", produces = {"application/json"})
	@ResponseBody
	public List<Person> getAllFromCache() throws SQLException {
		return personService.listAllFromCache();
	}
}

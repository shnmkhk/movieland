package com.rabbit.mdb;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.rabbit.mdb.dao.PersonNotFoundException;
import com.rabbit.mdb.model.Person;
import com.rabbit.mdb.service.PersonService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(path = "/{id}", produces = { "application/json" })
	@ResponseBody
	public Person getById(@PathVariable("id") final long id) throws PersonNotFoundException, SQLException {
		System.out.println("in getById method");
		return personService.getById(id);
	}

	@GetMapping(produces = { "application/json" })
	@ResponseBody
	public List<Person> getAll() throws SQLException {
		return personService.listAll();
	}

	@GetMapping(path = "/cache", produces = { "application/json" })
	@ResponseBody
	public Collection<Person> getAllFromCache() throws SQLException {
		return personService.listAllFromCache();
	}

	@RequestMapping(path = "/cache/streaming")
	public void getAllFromCacheStreaming(final HttpServletResponse response) throws SQLException, IOException {
		response.setContentType("application/json");
		try (JsonGenerator jGenerator = new JsonFactory().createGenerator(response.getOutputStream(), JsonEncoding.UTF8)) {
			jGenerator.writeStartArray();
			for (Person p : personService.listAllFromCache()) {
				jGenerator.writeStartObject();
				jGenerator.writeNumberField("id", p.getId());
				jGenerator.writeStringField("name", p.getName());
				jGenerator.writeStringField("address", p.getAddress());
				jGenerator.writeEndObject();
			}
			jGenerator.writeEndArray();
			jGenerator.close();
		} finally {
		}
	}
}

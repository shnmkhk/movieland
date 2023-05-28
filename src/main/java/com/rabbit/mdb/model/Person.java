package com.rabbit.mdb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String address;

	public static Person of(final long id, final String name, final String address) {
		return new Person(id, name, address);
	}

	public Person(final long id, final String name, final String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}
}

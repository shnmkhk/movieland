package com.rabbit.mdb.model;

import lombok.Data;

@Data
public class Person {

	private long id;
	private String name;
	private String address;
	public Person(final long id, final String name, final String address) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.address = address;
	}

}

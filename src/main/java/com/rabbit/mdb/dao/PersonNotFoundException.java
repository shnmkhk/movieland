package com.rabbit.mdb.dao;

public class PersonNotFoundException extends Exception {
	public PersonNotFoundException() {
	}

	public PersonNotFoundException(final String msg) {
		super(msg);
	}
	
	public PersonNotFoundException(final String msg, final Throwable t) {
		super(msg, t);
	}
}

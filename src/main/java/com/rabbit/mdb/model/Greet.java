package com.rabbit.mdb.model;

public class Greet {
	private long id;
	private String message;
	private Greet(final long id, final String message) {
		this.id = id;
		this.message = message;
	}
	public static Greet of(final long id, final String message) {
		return new Greet(id, message);
	}
}

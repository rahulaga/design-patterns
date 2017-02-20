package com.inferdata.strategy;

public class User {
	private String name;
	public User(String name) {
		this.name = name;
	}
	public void printJobComplete(Job job) {
		System.out.println("User " + this.name + ": Job #" + job.getId() + " is complete");
	}
	public String getName() {
		return this.name;
	}

}

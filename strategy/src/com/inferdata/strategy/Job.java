package com.inferdata.strategy;

public class Job {
	private static int JOB_NUMBER = 1;
	private int id = JOB_NUMBER++;
	private String content;
	private User user;
	private final static int DEFAULT_PRIORITY = 50;
	private int priority = DEFAULT_PRIORITY;
	public Job(User user, String content) {
		this.content = content;
		this.user = user;
	}
	public Job(User user, String content, int priority) {
		this.content = content;
		this.user = user;
		this.priority = priority;
	}
	public Job(String content) {
		this.content = content;
		this.user = null;
	}
	public Job(String content, int priority) {
		this.content = content;
		this.user = null;
		this.priority = priority;
	}
	public int getPriority() {
		return this.priority;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getContent() {
		return this.content;
	}
	public void done() {
		if (this.user!= null) {
			this.user.printJobComplete(this);
		}
	}
	public User getUser() {
		// TODO Auto-generated method stub
		return this.user;
	}

}

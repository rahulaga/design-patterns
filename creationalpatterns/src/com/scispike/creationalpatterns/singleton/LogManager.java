package com.scispike.creationalpatterns.singleton;

public class LogManager {
	private static final LogManager singleton = new LogManager();
	static public LogManager getInstance() {
		return singleton;
	}
	public void log(String message) {}
}

package com.scispike.creationalpatterns.singleton;

public class Client {
	public static void main(String[] args) {
		/*
		 *  HOW DO I OBTAIN 
		 */
		LogManager lm = LogManager.getInstance();
		lm.log("Some message");
	}
}

package com.scispike.creationalpatterns.shapes;

public abstract class Shape {
	abstract public void draw();
	// if using Java 1.7 or older...
	public static Shape create(String s) {
		Shape retValue = null;
		if (s.startsWith("#rect")) {
			retValue = new Rectangle();
		}
		else if (s.startsWith("#oval")) {
			retValue = new Oval();
		}
		else if (s.startsWith("#line")) {
			retValue = new Line();
		}
		return retValue;
	}
}

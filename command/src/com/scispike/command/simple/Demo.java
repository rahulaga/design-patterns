package com.scispike.command.simple;

public class Demo {
	public static void main(String[] args) {
		System.out.println("The sum of numbers from 1 to 100: " + sum(1,100, new Function() {
			
			@Override
			public int apply(int i) {
				return i;
			}
		}));
		System.out.println("The sum of squares from 1 to 10: " + sum(1,10, new Function() {
			
			@Override
			public int apply(int i) {
				return i*i;
			}
		}));
	}
	private static int sum(int lower, int upper, Function f) {
		int sum = 0;
		for (int i = lower; i <= upper; i++) {
			sum += f.apply(i);
		}
		return sum;
		
		// TYPE SOMETHING
		
	}
}

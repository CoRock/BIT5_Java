package com.corock.day04;

abstract class Abs {
	// anonymous class is possible to create object
	abstract void disp();
}

public class AnonymousInner {
	
	private int a = 10;
	public int b = 20;
	protected static int c = 30;
	
	public Abs abs = new Abs() {
		@Override
		void disp() {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);			
		}
	};
	
	public static void main(String[] args) {
		AnonymousInner ai = new AnonymousInner();
		ai.abs.disp();
	}
	
}
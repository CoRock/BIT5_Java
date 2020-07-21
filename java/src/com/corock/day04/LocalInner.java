package com.corock.day04;

// local class: any class exists in certain function
public class LocalInner {
	
	private int a = 10;
	public int b = 20;
	protected static int c = 30;
	
	public void output() {
		class Member {
			public void disp() {
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}
		}
		
		Member m = new Member();
		m.disp();
	}
	
	public static void main(String[] args) {
		LocalInner li = new LocalInner();
		li.output();	// call output() inner class included
	}
	
}
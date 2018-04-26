package com.corock.day04;

public class InstanceInner {

	private int a = 10;
	public int b = 20;
	protected static int c = 30;
	
	// Inner class: create class in outer class
	class Member {
		public void disp() {
			// it's accessible to all as there is not red line
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		// case 1
		InstanceInner ii = new InstanceInner();
		InstanceInner.Member m1 = ii.new Member();
		m1.disp();
		
		System.out.println();
		
		// case 2
		InstanceInner.Member m2 = new InstanceInner().new Member();
		m2.disp();
	}
}

package com.corock.day04;

public class StaticInner {
	
	private int a = 10;
	public int b = 20;
	
	// static field
	protected static int c = 30;
	
	// static inner class
	static class Member {
		public void disp() {
//			System.out.println(a);
//			System.out.println(b);
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		StaticInner.Member si = new StaticInner.Member();
		si.disp();		
	}
	
}

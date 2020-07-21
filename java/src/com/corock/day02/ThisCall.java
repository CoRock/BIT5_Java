package com.corock.day02;

public class ThisCall {

	// field
	private int a;
	private int b;
	
	// getter
	public int getA() {	return a; }
	public int getB() { return b; }
	
	// constructor
	public ThisCall() {
		// warning: this method must be located the first line!
		this(0, 0);	// a = b = 0;		
		System.out.println("default constructor");
	}

	public ThisCall(int data) {
		this(data, 0);	// a = data; b = 0;
		System.out.println("constructor with 1 param: " + data);
	}
	
	@Override
	public String toString() {
		return a + "\t" + b;
	}

	public ThisCall(int data1, int data2) {
//		this(data1, data2); (x)
		System.out.println("constructor with 2 param: " + data1 + " " + data2);
		a = data1;
		b = data2;
	}

	public static void main(String[] args) {
		
		// call constructor
		ThisCall tc1 = new ThisCall();
		System.out.println();
		ThisCall tc2 = new ThisCall(10);
		System.out.println();
		ThisCall tc3 = new ThisCall(10, 20);
		System.out.println();
		
		System.out.println("*** tc1, tc2 and tc3 getter results:");
		System.out.printf(tc1.getA() + "\t" + tc1.getB() + "%n");
		System.out.printf(tc2.getA() + "\t" + tc2.getB() + "%n");
		System.out.printf(tc3.getA() + "\t" + tc3.getB() + "%n");
		System.out.println();
		
		// if you write only object, implicitly call .toString() method
		System.out.println("*** tc1, tc2 and tc3 results:");
		System.out.println(tc1);
		System.out.println(tc2);
		System.out.println(tc3);
		System.out.println();
		
		System.out.println("*** tc1, tc2 and tc3 toString() results:");
		System.out.println(tc1.toString());
		System.out.println(tc2.toString());
		System.out.println(tc3.toString());
		System.out.println();
		
	}	// end of main
	
}

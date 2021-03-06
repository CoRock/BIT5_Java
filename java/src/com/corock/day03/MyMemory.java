package com.corock.day03;

import java.util.Scanner;

public abstract class MyMemory {

	// fields
	protected int arr[];
	protected int top;
	protected static int temp;	// temporary variable which functions push and pop
	private final static int ARR_MAX = 3;
	
	Scanner sc = new Scanner(System.in);
	
	// ╗ř╝║└┌
	MyMemory() {
		arr = new int[ARR_MAX];
		top = -1;
		temp = 0;
	}
	
	public void menu() {
		System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
		System.out.println("*** Select operation you want");
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Back");
		System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
		System.out.print(" ŽíŽí> ");
		int button = sc.nextInt();
		
		switch(button)
		{
		case 1:
			// exception handling
			if(!isFull()) {
				System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
				System.out.println("*** Input push value");
				System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
				System.out.print(" ŽíŽí> ");
				temp = sc.nextInt();
				push(temp);
			
			} else {
				System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
				System.out.println("Exception: stack overflow!");
			}
			
			break;
			
		case 2:
			// exception handling
			if(!isEmpty()) {
				temp = pop();
				
				System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
				System.out.println("data : " + temp);
			} else {
				System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
				System.out.println("Exception: stack underflow!");
			}
			
			break;
			
		case 3: return;
		}
	}
	
	public void push(int data) {
		arr[++top] = data;
		
		System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
		System.out.println("you succeed in input, babay!");
		System.out.println("ŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽíŽí");
	}
	
	// abstract method
	abstract public int pop();

	public boolean isFull() {
		if(top + 1 == ARR_MAX) return true;
		else				   return false;
	}
	
	public boolean isEmpty() {
		if(top == -1) return true;
		else		  return false;
	}		
	
}

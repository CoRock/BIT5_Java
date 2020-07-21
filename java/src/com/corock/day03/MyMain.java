package com.corock.day03;

import java.util.Scanner;

public class MyMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MyMemory mem;
		MyStack ms = new MyStack();
		MyQueue mq = new MyQueue();

		do {
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** Choose from the menu below");
			System.out.println("1. Stack");
			System.out.println("2. Queue");
			System.out.println("3. Exit");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.print(" 式式> ");
			int button = sc.nextInt();

			// dynamic binding
			switch (button) {
			case 1: mem = ms;	mem.menu();		break;
			case 2: mem = mq;	mem.menu();		break;
			case 3:
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
				System.out.println("*** Exit program, bye :)");
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
				System.exit(0);
			default:
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
				System.out.println("*** You entered incorrect number!");
				System.out.println("*** Please tell me again.");
				continue;
			}
		} while (true);
		
	}	// end of main
	
}	// end of MyMain class
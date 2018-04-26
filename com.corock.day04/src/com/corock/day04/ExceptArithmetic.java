package com.corock.day04;

import java.util.Scanner;

public class ExceptArithmetic {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/* test: 4/2 and 4/0 */
		int num1, num2;
		
		try {
			System.out.print("Input a dividend: ");
			num1 = sc.nextInt();
			
			System.out.print("Input a divisor: ");
			num2 = sc.nextInt();
			
			System.out.println(num1 + " / " + num2 + " is " + num1/num2);
		} catch(ArithmeticException ae) {
			System.out.println("don't set 0!");
			return;
		} finally {
			// finally is a high priority return
			System.out.println("hi test1");
		}
		
		System.out.println("hi test2");
		
	}	
	
}
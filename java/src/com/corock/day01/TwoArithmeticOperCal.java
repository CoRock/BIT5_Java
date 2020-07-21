package com.corock.day01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwoArithmeticOperCal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ex. "11+22+33+4+5-10";	result = 5;
		System.out.print("Enter expression you want : ");		
		String exp = sc.nextLine();

		int plusSum = 0;	// save addition operands
		int minusSum = 0;	// save subtraction operands
		
		// save operation lists
		String[] operand = exp.split("\\+|\\-");
		Queue<Character> operator = new LinkedList<Character>();
		
		// analysis operators
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) == '+') 		{ operator.add('+'); continue; }
			else if(exp.charAt(i) == '-') 	{ operator.add('-'); continue; }
			else							{ continue; }
		}
		
		// the first operand puts directly
		plusSum = Integer.parseInt(operand[0]);
		
		// and then analyze lists whether '+' or '-' from the second operand
		for(int i = 1; i < operand.length; i++) {
			try {
				char ch = operator.poll();
				if(ch == '+') { plusSum += Integer.parseInt(operand[i]); continue; }
				else if(ch == '-') { minusSum += Integer.parseInt(operand[i]); continue; }
			} catch (NullPointerException e) { break; }
		}
		
		System.out.println("Result : " + (plusSum - minusSum));
	}
	
}
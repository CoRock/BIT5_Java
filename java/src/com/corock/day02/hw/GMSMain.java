package com.corock.day02.hw;

import java.util.Scanner;

public class GMSMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GradeMagSystem gms = new GradeMagSystem();
		int button = 0;
		
		do {
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** Select number you want");
			System.out.println("1. Input student info");
			System.out.println("2. Print out all students");
			System.out.println("3. Search student info");
			System.out.println("4. Delete student info");
			System.out.println("5. Correct student info");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			button = sc.nextInt();
			
			switch(button)
			{
			case 1: gms.input(); break;
			case 2: gms.showAllInfo(); break;
			case 3: gms.search(); break;
			case 4: gms.deleteInfo(); break;
			case 5: gms.correctGrade(); break;
			default:
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
				System.out.println("You entered incorrect number!");
				System.out.println("Please try again :("); continue;
			}
			
		} while(true);
	}	
	
}

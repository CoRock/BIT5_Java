package com.corock.day02.hw;

import java.util.Scanner;

public class GradeMagSystem {

	// fields
	private Name myName;
	private Subject kor;
	private Subject eng;
	private Subject math;
	private int total;
	private float avg;
	
	private static int count;		// count variable of object arrays
	private static int pos;			// count variable for search
	private static int tempGrade;	// temp variable for target score
	
	GradeMagSystem[] gm;
	Scanner sc = new Scanner(System.in);
	
	// constructors
	GradeMagSystem() {
		myName = new Name();
		kor = new Subject();
		eng = new Subject();
		math = new Subject();
		total = 0;
		avg = 0;
		count = 0;
		pos = 0;
		
		// create object arrays
		gm = new GradeMagSystem[50];
	}
	
	GradeMagSystem(String name, int kor, int eng, int math, int total, float avg) {
		myName = new Name(name);
		this.kor = new Subject(kor);
		this.eng = new Subject(eng);
		this.math = new Subject(math);
		this.total = total;
		this.avg = avg;
	}
	
	// takeCareOf(): automatically and implicitly calculate sum, average
	public void takeCareOf(int kor, int eng, int math) {
		total = kor + eng + math;
		avg = total / 3.f;
	}
	
	// input(): one by one
	public void input() {
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** Input Student infomation");
		System.out.println("*** Input name:");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		myName.setName(sc.next());
//		myName.setName(sc.nextLine());
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** Input Korean score:");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		kor.setSubj(sc.nextInt());
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** Input English score:");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		eng.setSubj(sc.nextInt());
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** Input Math score:");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		math.setSubj(sc.nextInt());
		
		// call takeCareOf() method
		takeCareOf(kor.getSubj(), eng.getSubj(), math.getSubj());
		
		// object injection!
		gm[count++] = new GradeMagSystem(myName.getName(), kor.getSubj(),
												eng.getSubj(), math.getSubj(), total, avg);
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** Successful Registration!");
		
		// use insertion sort
		if(count > 0) {
			insertionSort(gm, count);
		}
	}
	
	// implementation for insertion sort
	public void insertionSort(GradeMagSystem[] gm, int cnt) {
		int i, j, totalKey;
		GradeMagSystem temp;
		
		try {
			for (i = 1; i < cnt; i++) {
				totalKey = gm[i].total;	// get sum second index
				for (j = i - 1; j >= 0 && gm[j].total < totalKey; j--) {
					temp = gm[j];
					gm[j] = gm[j + 1];	// shift
					gm[j + 1] = temp;	// change
				}
			}
		} catch(NullPointerException ne) { }
	}
	
	// return true if you tried search by using name and there is name
	public boolean isCorrespond(String wantToName) {
		// initialize 0 as search in order
		pos = 0;
		
		while(true) {
			try {
				if(gm[pos].myName.getName().equals(wantToName)) {
					return true;
				}					
			} catch(NullPointerException ne) {
				// exception handling: if you want to find name
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
				System.out.println("*** there is no name you want to find");
				return false;
			}
			pos++;
			continue;
		}
	}
	
	// printout infomation for a person
	public void showTargetInfo(String wantToName) {
		if (isCorrespond(wantToName)) {
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
			System.out.println(gm[pos].myName.getName() + "\t" + gm[pos].kor.getSubj() + "\t"
							+ gm[pos].eng.getSubj() + "\t" + gm[pos].math.getSubj() + "\t"
							+ gm[pos].total + "\t" + gm[pos].avg);
		}
	}
	
	// printout infomation all students
	public void showAllInfo() {
		if(count == 0) {
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** Now, here is no data");
			System.out.println("*** back to the main menu");
			return;
		}
		System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
		for(int i = 0; i < gm.length; i++) {
			try {
				System.out.println(gm[i].myName.getName() + "\t" + gm[i].kor.getSubj() + "\t"
								+ gm[i].eng.getSubj() + "\t" + gm[i].math.getSubj() + "\t"
								+ gm[i].total + "\t" + gm[i].avg);
			} catch(NullPointerException ne) { break; }
			//if(gm[i].myName.getName() == "X")
		}
	}
	
	// search a student
	public void search() {
		if(count == 0) {
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** Now, here is no data");
			System.out.println("*** back to the main menu");
			return;
		}
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** play search a student");
		System.out.println("*** select how to find student?");
		System.out.println("*** 1. name" + "\t" + "2. score");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		int button = sc.nextInt();
		
		switch(button)
		{
		case 1:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** search for student's name");
			System.out.println("*** input name:");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			String wantToName = sc.next();
			
			// print out infomation of student if you want to find name
			if(isCorrespond(wantToName)) { showTargetInfo(wantToName); }
			break;
			
		case 2:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** search for student's score");
			System.out.println("*** input score:");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			int tempTotal = sc.nextInt();
			
			break;
			
		default:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** you entered incorrect number!");
			System.out.println("*** please try again :("); break;
		}
	}

	// case 1, 2: whether object of student is the latest or not
	public void deleteInfo() {
		if(count == 0) {
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** Now, here is no data");
			System.out.println("*** back to the main menu");
			return;
		}
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** delete a student infomation");
		System.out.println("*** input name:");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		String wantToName = sc.next();
		
		if(isCorrespond(wantToName)) { showTargetInfo(wantToName); }
		else { return; }
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** Now, " + wantToName + " exists");
		System.out.println("*** do you really want to delete data?");
		System.out.println("*** 1. Yes" + "\t" + "2. Nope");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		int button = sc.nextInt();
		
		switch(button)
		{
		case 1:
			// if data is located the latest
			if(pos == count) { gm[pos] = null; }
			else {
				// or not
				while (pos < count - 1) {
					gm[pos] = gm[pos + 1];
					pos++;
					continue;
				}
				
				// set null to the latest
				gm[pos] = null;
			}
			
			count--;
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** successful deletion");
			break;
			
		case 2:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** back to the main");
			return;
		default:
			break;
		}
	}	// end of deleteInfo() method
	
	// correct a student data
	public void correctGrade() {
		if(count == 0) {
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** Now, here is no data");
			System.out.println("*** back to the main menu");
			return;
		}
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** search for student's name.");
		System.out.println("*** input name:");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		String wantToName = sc.next();
		
		if(isCorrespond(wantToName)) { showTargetInfo(wantToName); }
		else { return; }
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("*** Now, " + wantToName + " exists.");
		System.out.println("*** Select score you try to change.");
		System.out.println("*** 1. Korean" + "\t" + "2. English" + "\t" + "3. Math");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		int button = sc.nextInt();
		
		switch(button)
		{
		case 1:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** correct Korean score.");
			System.out.println("*** input score: ");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			tempGrade = sc.nextInt();
			
			// modify score in Korean
			gm[pos].kor.setSubj(tempGrade);
			
			// call again takeCareOf() method
			takeCareOf(gm[pos].kor.getSubj(), gm[pos].eng.getSubj(), gm[pos].math.getSubj());
			
			// set again results
			gm[pos].total = gm[pos].kor.getSubj() + gm[pos].eng.getSubj() + gm[pos].math.getSubj();
			gm[pos].avg = gm[pos].total / 3.f;
			
			// sort again
			insertionSort(gm, count);
			
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** completed!");
			
			break;
			
		case 2:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** correct English score.");
			System.out.println("*** input score: ");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			tempGrade = sc.nextInt();
			
			// modify score in English
			gm[pos].eng.setSubj(tempGrade);
			
			// call again takeCareOf() method
			takeCareOf(gm[pos].kor.getSubj(), gm[pos].eng.getSubj(), gm[pos].math.getSubj());
			gm[pos].total = gm[pos].kor.getSubj() + gm[pos].eng.getSubj() + gm[pos].math.getSubj();
			gm[pos].avg = gm[pos].total / 3.f;
			
			insertionSort(gm, count);
			
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** completed!");
			
			break;
			
		case 3:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** correct Mathemetics score.");
			System.out.println("*** input score: ");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			tempGrade = sc.nextInt();
			
			// modify score in Mathemetics
			gm[pos].math.setSubj(tempGrade);
			
			// call again takeCareOf() method
			takeCareOf(gm[pos].kor.getSubj(), gm[pos].eng.getSubj(), gm[pos].math.getSubj());
			gm[pos].total = gm[pos].kor.getSubj() + gm[pos].eng.getSubj() + gm[pos].math.getSubj();
			gm[pos].avg = gm[pos].total / 3.f;
			
			insertionSort(gm, count);
			
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** completed!");
			
			break;
			
		default:
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("*** you entered incorrect number!");
			System.out.println("*** please try again :("); break;
		}
	}	
	
}

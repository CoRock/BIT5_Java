package com.corock.day07.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class GradeMagSystem {
	
	// ÇÊµå
	ArrayList<Student> list;
	Student stu;	
	
	// »ý¼ºÀÚ
	GradeMagSystem() {
		// ArrayList »ý¼º		
		list = new ArrayList<>();
		stu = null;
	}
	
	// 1: ±¹¿µ¼ö Á¡¼ö¸¦ ÀÔ·ÂÇÏ¸é ÃÑÁ¡, Æò±ÕÀ» ÀÚµ¿ °è»ê ÈÄ ³»¸²Â÷¼øÀ¸·Î Á¤·Ä
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		stu = new Student();
				
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇÐ»ý Á¤º¸¸¦ ÀÔ·ÂÇÕ´Ï´Ù.");
		System.out.println("ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		stu.setName(sc.next());
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("±¹¾î ¼ºÀûÀ» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		stu.setKor(sc.nextInt());
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("¿µ¾î ¼ºÀûÀ» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		stu.setEng(sc.nextInt());
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("¼öÇÐ ¼ºÀûÀ» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		stu.setMath(sc.nextInt());
		
		// ÃÑÁ¡, Æò±Õ °è»ê
		stu.setTotal(stu.getKor() + stu.getEng() + stu.getMath());
		stu.setAvg(stu.getTotal() / 3.f);
		
		// ±¹¿µ¼ö, ÃÑÁ¡, Æò±Õ±îÁö ´ã±ä µ¥ÀÌÅÍ »ðÀÔ
		list.add(stu);
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇÐ»ý Á¤º¸ µî·Ï ¿Ï·á!");
		
		Descend Descend = new Descend();
		Collections.sort(list, Descend);
	}
	
	// 2: ÇÐ»ý ÀüÃ¼ Ãâ·Â
	public void showAllInfo() {
		// ÇÐ»ý µ¥ÀÌÅÍ°¡ 1µµ ¾ø´Â °æ¿ì
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
		for (Student stu : list)
			System.out.println(stu);
	}
	
	// 3¹ø ±â´É - °Ë»ö
	public void search() {
		// ÇÐ»ý µ¥ÀÌÅÍ°¡ 1µµ ¾ø´Â °æ¿ì
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}

		Scanner sc = new Scanner(System.in);
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇÐ»ý ÀÌ¸§À¸·Î °Ë»öÇÕ´Ï´Ù.");
		System.out.println("Ã£°íÀÚ ÇÏ´Â ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		String wantToName = sc.next();

		// Ã£´Â ÀÌ¸§ÀÌ ÀÖÀ¸¸é ±× ÇÐ»ý¿¡ ´ëÇÑ Á¤º¸¸¦ Ãâ·ÂÇÑ´Ù.
		showTargetInfo(wantToName);
	}
	
	public int showTargetInfo(String wantToName) {
		Iterator<Student> it = list.iterator();
		
		while(it.hasNext()) {
			Student target = it.next();
			String name = target.getName();

			if(name.equals(wantToName)) {
				int idx = list.indexOf(target);

				// Ãâ·Â
				System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
				System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
				System.out.println(list.get(idx));
				
				return idx;
				
			} else if(list.contains(it)) {
				System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
				System.out.println("Ã£°íÀÚ ÇÏ´Â ÀÌ¸§ÀÌ ¾ø½À´Ï´Ù.");
			}
		}
		
		return -1;
	}
	
	// 4: ÇÐ»ý µ¥ÀÌÅÍ »èÁ¦
	public void deleteInfo() {
		// ÇÐ»ý µ¥ÀÌÅÍ°¡ 1µµ ¾ø´Â °æ¿ì
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇÐ»ý Á¤º¸¸¦ »èÁ¦ÇÕ´Ï´Ù.");
		System.out.println("Áö¿ì°íÀÚ ÇÏ´Â ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		String wantToName = sc.next();
		
		int idx = showTargetInfo(wantToName);
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇöÀç " + wantToName + "ÀÇ µ¥ÀÌÅÍ°¡ Á¸ÀçÇÕ´Ï´Ù.");
		System.out.println("Á¤¸» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?");
		System.out.println("1. ³×" + "\t" + "2. ¾Æ´Ï¿À");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		int button = sc.nextInt();
		
		switch(button)
		{
		case 1:
			list.remove(idx);
			
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("»èÁ¦ ¿Ï·á!");
		case 2:
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("¸ÞÀÎ È­¸éÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
			return;
		default:
			break;
		}
	}	// end of deleteInfo()
	
	
	// ÇÐ»ý ¼ºÀû ¼öÁ¤
	public void correctGrade() {
		// ÇÐ»ý µ¥ÀÌÅÍ°¡ 1µµ ¾ø´Â °æ¿ì
		if (list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇÐ»ý ÀÌ¸§À¸·Î °Ë»öÇÕ´Ï´Ù.");
		System.out.println("Ã£°íÀÚ ÇÏ´Â ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		String wantToName = sc.next();

		int idx = showTargetInfo(wantToName);

		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇöÀç " + wantToName + "ÀÇ µ¥ÀÌÅÍ°¡ ´ÙÀ½°ú °°½À´Ï´Ù.");
		System.out.println("¾î¶² °ú¸ñÀÇ ¼ºÀûÀ» ¼öÁ¤ÇÏ½Ã°Ú½À´Ï±î?");
		System.out.println("1. ±¹¾î" + "\t" + "2. ¿µ¾î" + "\t" + "3. ¼öÇÐ");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.print("¡¡¦¡¦¡> ");
		int button = sc.nextInt();

		switch (button) {
		case 1:
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("±¹¾î ¼ºÀûÀ» ¼öÁ¤ÇÕ´Ï´Ù.");
			System.out.println("¼öÁ¤ÇÒ Á¡¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.print("¡¡¦¡¦¡> ");
			temp = sc.nextInt();
			list.get(idx).setKor(temp);

			break;

		case 2:
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("¿µ¾î ¼ºÀûÀ» ¼öÁ¤ÇÕ´Ï´Ù.");
			System.out.println("¼öÁ¤ÇÒ Á¡¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.print("¡¡¦¡¦¡> ");
			temp = sc.nextInt();
			list.get(idx).setEng(temp);
			
			break;

		case 3:
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("¼öÇÐ ¼ºÀûÀ» ¼öÁ¤ÇÕ´Ï´Ù.");
			System.out.println("¼öÁ¤ÇÒ Á¡¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.print("¡¡¦¡¦¡> ");
			temp = sc.nextInt();
			list.get(idx).setMath(temp);

			break;
			
		default:
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("Àß¸øµÈ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¿´½À´Ï´Ù.");
			System.out.println("´Ù½Ã ½ÃµµÇØÁÖ¼¼¿ä.");
			
			break;
		}
		
		// ÃÑÁ¡, Æò±Õ °è»ê
		list.get(idx).setTotal(list.get(idx).getKor() + list.get(idx).getEng() + list.get(idx).getMath());
		list.get(idx).setAvg(list.get(idx).getTotal() / 3.f);
		
		Descend Descend = new Descend();
		Collections.sort(list, Descend);
		
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("¼öÁ¤ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù!");
		System.out.println("È®ÀÎÇØº¸»ï¤¾¤¾");
	}
	
	public void emptyStudentMessage() {
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇöÀç µî·ÏµÈ ÇÐ»ýÀÌ 1µµ ¾ø½À´Ï´Ù.");
		System.out.println("¸ÞÀÎ È­¸éÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
	}
}

//³»¸²Â÷¼ø Á¤·Ä ¸Þ¼Òµå
class Descend implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o2.compareTo(o1);
	}
}
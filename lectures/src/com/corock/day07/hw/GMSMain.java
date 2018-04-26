package com.corock.day07.hw;

import java.util.Scanner;

public class GMSMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		GradeMagSystem gms = new GradeMagSystem();
		int button = 0;
		
		do {
			System.out.println("──────────────────");
			System.out.println("번호를 선택하세요.");
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 전체 출력");
			System.out.println("3. 특정 학생 검색");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 학생 성적 수정");
			System.out.println("──────────────────");
			button = sc.nextInt();
			
			switch(button)
			{
			case 1: gms.input(); break;
			case 2: gms.showAllInfo(); break;
			case 3: gms.search(); break;
			case 4: gms.deleteInfo(); break;
			case 5: gms.correctGrade(); break;
			default:
				System.out.println("──────────────────");
				System.out.println("잘못된 번호를 입력하였습니다.");
				System.out.println("다시 입력하세요."); continue;
			}
			
		} while(true);
		
	}	// end of main
	
}	// end of class
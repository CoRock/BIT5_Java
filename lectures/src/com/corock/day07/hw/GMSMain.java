package com.corock.day07.hw;

import java.util.Scanner;

public class GMSMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		GradeMagSystem gms = new GradeMagSystem();
		int button = 0;
		
		do {
			System.out.println("������������������������������������");
			System.out.println("��ȣ�� �����ϼ���.");
			System.out.println("1. �л� ���� �Է�");
			System.out.println("2. �л� ��ü ���");
			System.out.println("3. Ư�� �л� �˻�");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("������������������������������������");
			button = sc.nextInt();
			
			switch(button)
			{
			case 1: gms.input(); break;
			case 2: gms.showAllInfo(); break;
			case 3: gms.search(); break;
			case 4: gms.deleteInfo(); break;
			case 5: gms.correctGrade(); break;
			default:
				System.out.println("������������������������������������");
				System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�.");
				System.out.println("�ٽ� �Է��ϼ���."); continue;
			}
			
		} while(true);
		
	}	// end of main
	
}	// end of class
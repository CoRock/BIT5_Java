package com.corock.day07.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class GradeMagSystem {
	
	// �ʵ�
	ArrayList<Student> list;
	Student stu;	
	
	// ������
	GradeMagSystem() {
		// ArrayList ����		
		list = new ArrayList<>();
		stu = null;
	}
	
	// 1: ������ ������ �Է��ϸ� ����, ����� �ڵ� ��� �� ������������ ����
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		stu = new Student();
				
		System.out.println("������������������������������������");
		System.out.println("�л� ������ �Է��մϴ�.");
		System.out.println("�̸��� �Է��ϼ���.");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		stu.setName(sc.next());
		
		System.out.println("������������������������������������");
		System.out.println("���� ������ �Է��ϼ���.");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		stu.setKor(sc.nextInt());
		
		System.out.println("������������������������������������");
		System.out.println("���� ������ �Է��ϼ���.");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		stu.setEng(sc.nextInt());
		
		System.out.println("������������������������������������");
		System.out.println("���� ������ �Է��ϼ���.");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		stu.setMath(sc.nextInt());
		
		// ����, ��� ���
		stu.setTotal(stu.getKor() + stu.getEng() + stu.getMath());
		stu.setAvg(stu.getTotal() / 3.f);
		
		// ������, ����, ��ձ��� ��� ������ ����
		list.add(stu);
		
		System.out.println("������������������������������������");
		System.out.println("�л� ���� ��� �Ϸ�!");
		
		Descend Descend = new Descend();
		Collections.sort(list, Descend);
	}
	
	// 2: �л� ��ü ���
	public void showAllInfo() {
		// �л� �����Ͱ� 1�� ���� ���
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
		for (Student stu : list)
			System.out.println(stu);
	}
	
	// 3�� ��� - �˻�
	public void search() {
		// �л� �����Ͱ� 1�� ���� ���
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}

		Scanner sc = new Scanner(System.in);
		
		System.out.println("������������������������������������");
		System.out.println("�л� �̸����� �˻��մϴ�.");
		System.out.println("ã���� �ϴ� �̸��� �Է��ϼ���.");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		String wantToName = sc.next();

		// ã�� �̸��� ������ �� �л��� ���� ������ ����Ѵ�.
		showTargetInfo(wantToName);
	}
	
	public int showTargetInfo(String wantToName) {
		Iterator<Student> it = list.iterator();
		
		while(it.hasNext()) {
			Student target = it.next();
			String name = target.getName();

			if(name.equals(wantToName)) {
				int idx = list.indexOf(target);

				// ���
				System.out.println("������������������������������������");
				System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
				System.out.println(list.get(idx));
				
				return idx;
				
			} else if(list.contains(it)) {
				System.out.println("������������������������������������");
				System.out.println("ã���� �ϴ� �̸��� �����ϴ�.");
			}
		}
		
		return -1;
	}
	
	// 4: �л� ������ ����
	public void deleteInfo() {
		// �л� �����Ͱ� 1�� ���� ���
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������������������������������������");
		System.out.println("�л� ������ �����մϴ�.");
		System.out.println("������� �ϴ� �̸��� �Է��ϼ���.");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		String wantToName = sc.next();
		
		int idx = showTargetInfo(wantToName);
		
		System.out.println("������������������������������������");
		System.out.println("���� " + wantToName + "�� �����Ͱ� �����մϴ�.");
		System.out.println("���� �����Ͻðڽ��ϱ�?");
		System.out.println("1. ��" + "\t" + "2. �ƴϿ�");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		int button = sc.nextInt();
		
		switch(button)
		{
		case 1:
			list.remove(idx);
			
			System.out.println("������������������������������������");
			System.out.println("���� �Ϸ�!");
		case 2:
			System.out.println("������������������������������������");
			System.out.println("���� ȭ������ ���ư��ϴ�.");
			return;
		default:
			break;
		}
	}	// end of deleteInfo()
	
	
	// �л� ���� ����
	public void correctGrade() {
		// �л� �����Ͱ� 1�� ���� ���
		if (list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		
		System.out.println("������������������������������������");
		System.out.println("�л� �̸����� �˻��մϴ�.");
		System.out.println("ã���� �ϴ� �̸��� �Է��ϼ���.");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		String wantToName = sc.next();

		int idx = showTargetInfo(wantToName);

		System.out.println("������������������������������������");
		System.out.println("���� " + wantToName + "�� �����Ͱ� ������ �����ϴ�.");
		System.out.println("� ������ ������ �����Ͻðڽ��ϱ�?");
		System.out.println("1. ����" + "\t" + "2. ����" + "\t" + "3. ����");
		System.out.println("������������������������������������");
		System.out.print("������> ");
		int button = sc.nextInt();

		switch (button) {
		case 1:
			System.out.println("������������������������������������");
			System.out.println("���� ������ �����մϴ�.");
			System.out.println("������ ������ �Է��ϼ���.");
			System.out.println("������������������������������������");
			System.out.print("������> ");
			temp = sc.nextInt();
			list.get(idx).setKor(temp);

			break;

		case 2:
			System.out.println("������������������������������������");
			System.out.println("���� ������ �����մϴ�.");
			System.out.println("������ ������ �Է��ϼ���.");
			System.out.println("������������������������������������");
			System.out.print("������> ");
			temp = sc.nextInt();
			list.get(idx).setEng(temp);
			
			break;

		case 3:
			System.out.println("������������������������������������");
			System.out.println("���� ������ �����մϴ�.");
			System.out.println("������ ������ �Է��ϼ���.");
			System.out.println("������������������������������������");
			System.out.print("������> ");
			temp = sc.nextInt();
			list.get(idx).setMath(temp);

			break;
			
		default:
			System.out.println("������������������������������������");
			System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�.");
			System.out.println("�ٽ� �õ����ּ���.");
			
			break;
		}
		
		// ����, ��� ���
		list.get(idx).setTotal(list.get(idx).getKor() + list.get(idx).getEng() + list.get(idx).getMath());
		list.get(idx).setAvg(list.get(idx).getTotal() / 3.f);
		
		Descend Descend = new Descend();
		Collections.sort(list, Descend);
		
		System.out.println("������������������������������������");
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println("Ȯ���غ��菉��");
	}
	
	public void emptyStudentMessage() {
		System.out.println("������������������������������������");
		System.out.println("���� ��ϵ� �л��� 1�� �����ϴ�.");
		System.out.println("���� ȭ������ ���ư��ϴ�.");
	}
}

//�������� ���� �޼ҵ�
class Descend implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o2.compareTo(o1);
	}
}
package com.corock.day07.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class GradeMagSystem {
	
	// в萄
	ArrayList<Student> list;
	Student stu;	
	
	// 儅撩濠
	GradeMagSystem() {
		// ArrayList 儅撩		
		list = new ArrayList<>();
		stu = null;
	}
	
	// 1: 措艙熱 薄熱蒂 殮溘ж賊 識薄, ゎ敕擊 濠翕 啗骯 �� 頂葡離牖戲煎 薑溺
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		stu = new Student();
				
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("з儅 薑爾蒂 殮溘м棲棻.");
		System.out.println("檜葷擊 殮溘ж撮蹂.");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		stu.setName(sc.next());
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("措橫 撩瞳擊 殮溘ж撮蹂.");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		stu.setKor(sc.nextInt());
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("艙橫 撩瞳擊 殮溘ж撮蹂.");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		stu.setEng(sc.nextInt());
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("熱з 撩瞳擊 殮溘ж撮蹂.");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		stu.setMath(sc.nextInt());
		
		// 識薄, ゎ敕 啗骯
		stu.setTotal(stu.getKor() + stu.getEng() + stu.getMath());
		stu.setAvg(stu.getTotal() / 3.f);
		
		// 措艙熱, 識薄, ゎ敕梱雖 氬曹 等檜攪 鳶殮
		list.add(stu);
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("з儅 薑爾 蛔煙 諫猿!");
		
		Descend Descend = new Descend();
		Collections.sort(list, Descend);
	}
	
	// 2: з儅 瞪羹 轎溘
	public void showAllInfo() {
		// з儅 等檜攪陛 1紫 橈朝 唳辦
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
		for (Student stu : list)
			System.out.println(stu);
	}
	
	// 3廓 晦棟 - 匐儀
	public void search() {
		// з儅 等檜攪陛 1紫 橈朝 唳辦
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}

		Scanner sc = new Scanner(System.in);
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("з儅 檜葷戲煎 匐儀м棲棻.");
		System.out.println("瓊堅濠 ж朝 檜葷擊 殮溘ж撮蹂.");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		String wantToName = sc.next();

		// 瓊朝 檜葷檜 氈戲賊 斜 з儅縑 渠и 薑爾蒂 轎溘и棻.
		showTargetInfo(wantToName);
	}
	
	public int showTargetInfo(String wantToName) {
		Iterator<Student> it = list.iterator();
		
		while(it.hasNext()) {
			Student target = it.next();
			String name = target.getName();

			if(name.equals(wantToName)) {
				int idx = list.indexOf(target);

				// 轎溘
				System.out.println("式式式式式式式式式式式式式式式式式式");
				System.out.println("NAME /  KOR  /  ENG  /  MATH  / TOTAL / AVERAGE");
				System.out.println(list.get(idx));
				
				return idx;
				
			} else if(list.contains(it)) {
				System.out.println("式式式式式式式式式式式式式式式式式式");
				System.out.println("瓊堅濠 ж朝 檜葷檜 橈蝗棲棻.");
			}
		}
		
		return -1;
	}
	
	// 4: з儅 等檜攪 餉薯
	public void deleteInfo() {
		// з儅 等檜攪陛 1紫 橈朝 唳辦
		if(list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("з儅 薑爾蒂 餉薯м棲棻.");
		System.out.println("雖辦堅濠 ж朝 檜葷擊 殮溘ж撮蹂.");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		String wantToName = sc.next();
		
		int idx = showTargetInfo(wantToName);
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("⑷營 " + wantToName + "曖 等檜攪陛 襄營м棲棻.");
		System.out.println("薑蜓 餉薯ж衛啊蝗棲梱?");
		System.out.println("1. 啻" + "\t" + "2. 嬴棲螃");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		int button = sc.nextInt();
		
		switch(button)
		{
		case 1:
			list.remove(idx);
			
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.println("餉薯 諫猿!");
		case 2:
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.println("詭檣 �飛橉虞� 給嬴骨棲棻.");
			return;
		default:
			break;
		}
	}	// end of deleteInfo()
	
	
	// з儅 撩瞳 熱薑
	public void correctGrade() {
		// з儅 等檜攪陛 1紫 橈朝 唳辦
		if (list.isEmpty()) {
			emptyStudentMessage();
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("з儅 檜葷戲煎 匐儀м棲棻.");
		System.out.println("瓊堅濠 ж朝 檜葷擊 殮溘ж撮蹂.");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		String wantToName = sc.next();

		int idx = showTargetInfo(wantToName);

		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("⑷營 " + wantToName + "曖 等檜攪陛 棻擠婁 偽蝗棲棻.");
		System.out.println("橫雯 婁跡曖 撩瞳擊 熱薑ж衛啊蝗棲梱?");
		System.out.println("1. 措橫" + "\t" + "2. 艙橫" + "\t" + "3. 熱з");
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.print("﹛式式> ");
		int button = sc.nextInt();

		switch (button) {
		case 1:
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.println("措橫 撩瞳擊 熱薑м棲棻.");
			System.out.println("熱薑й 薄熱蒂 殮溘ж撮蹂.");
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			temp = sc.nextInt();
			list.get(idx).setKor(temp);

			break;

		case 2:
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.println("艙橫 撩瞳擊 熱薑м棲棻.");
			System.out.println("熱薑й 薄熱蒂 殮溘ж撮蹂.");
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			temp = sc.nextInt();
			list.get(idx).setEng(temp);
			
			break;

		case 3:
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.println("熱з 撩瞳擊 熱薑м棲棻.");
			System.out.println("熱薑й 薄熱蒂 殮溘ж撮蹂.");
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.print("﹛式式> ");
			temp = sc.nextInt();
			list.get(idx).setMath(temp);

			break;
			
		default:
			System.out.println("式式式式式式式式式式式式式式式式式式");
			System.out.println("澀跤脹 廓�ㄧ� 殮溘ж艘蝗棲棻.");
			System.out.println("棻衛 衛紫п輿撮蹂.");
			
			break;
		}
		
		// 識薄, ゎ敕 啗骯
		list.get(idx).setTotal(list.get(idx).getKor() + list.get(idx).getEng() + list.get(idx).getMath());
		list.get(idx).setAvg(list.get(idx).getTotal() / 3.f);
		
		Descend Descend = new Descend();
		Collections.sort(list, Descend);
		
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("熱薑檜 諫猿腎歷蝗棲棻!");
		System.out.println("�挫恉媞蜓鴾黎�");
	}
	
	public void emptyStudentMessage() {
		System.out.println("式式式式式式式式式式式式式式式式式式");
		System.out.println("⑷營 蛔煙脹 з儅檜 1紫 橈蝗棲棻.");
		System.out.println("詭檣 �飛橉虞� 給嬴骨棲棻.");
	}
}

//頂葡離牖 薑溺 詭模萄
class Descend implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o2.compareTo(o1);
	}
}
package com.corock.day07.hw;

public class Student implements Comparable<Student> {
	// 필드
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float avg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	@Override
	public int compareTo(Student s) {
		// 전자가 더 큰 경우
		if(this.getTotal() > s.getTotal()) return 1;
		// 후자가 더 큰 경우
		else if(this.getTotal() < s.getTotal()) return -1;
		// 같은 경우
		else return 0;
	}
	
	@Override	// 출력 결과 오버라이딩
	public String toString() {
		return getName() + "\t" + getKor() + "\t" + getEng() + "\t" + + getMath() + "\t" + getTotal() + "\t" + getAvg(); 
	}
}

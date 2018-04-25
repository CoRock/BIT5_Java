package com.corock.day03;

public class MyStack extends MyMemory {

	@Override
	public int pop() {
		return arr[top--];
	}
	
}
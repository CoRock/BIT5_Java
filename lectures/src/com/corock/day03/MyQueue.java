package com.corock.day03;

public class MyQueue extends MyMemory {

	public void shift() {
		for(int i = 0; i < top; i++) {
			arr[i] = arr[i + 1];
		}
	}
	
	@Override
	public int pop() {
		temp = arr[0];
		shift();
		top--;
		
		return temp;
	}	
	
}

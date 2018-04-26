package com.corock.day07;

public class InterfaceThread implements Runnable {
	
	// field
	private int[] temp;
	
	// constructor
	public InterfaceThread() {
		temp = new int[10];

		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	
	@Override
	public void run() {
		for(int start : temp) {
			try { Thread.sleep(1000); }
			catch(InterruptedException ie) { ie.printStackTrace(); }
			
			System.out.printf("thread name: %s, ", Thread.currentThread().getName());
			System.out.printf("temp value: %d %n", start);
		}
	}
	
	public static void main(String[] args) {
		
		InterfaceThread it = new InterfaceThread();
		
		// interface�� �����带 �� �� �ִ� ȯ���̱� ������
		// thread ��ü�� �����ؾ� ��
		Thread t = new Thread(it, "CoRock");
		t.start();
		
	}	// end of main
	
}	// end of class
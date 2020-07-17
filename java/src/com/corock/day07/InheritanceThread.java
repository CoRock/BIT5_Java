package com.corock.day07;

public class InheritanceThread extends Thread {
	
	// field
	private int[] temp;
	
	// constructor
	public InheritanceThread(String threadName) {
		super(threadName);

		temp = new int[10];

		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	
	@Override
	public void run() {
		for(int start : temp) {
			try { sleep(1000); }
			catch(InterruptedException ie) { ie.printStackTrace(); }
			
			System.out.printf("thread name: %s, ", currentThread().getName());
			System.out.printf("temp value: %d %n", start);
		}
	}
	
	// main
	public static void main(String[] args) {
		InheritanceThread st = new InheritanceThread("CoRock");
		st.start();
	}	// end of main
	
}	// end of class

package com.corock.day02;

public class TwoDimArr {

	public static void main(String[] args) {
		
		int[][] arr;
		arr = new int[2][];
		
		arr[0] = new int[3];
		arr[1] = new int[7];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 1 + i * j;
				System.out.println("arr[" + i + "][" + j + "] : " + arr[i][j]);
			} System.out.println();
		} System.out.println();
		
		// int a[6] = { 1, 2, 3, 4, 5, 6 }; -> error!
		int[] a = { 1, 2, 3, 4, 5, 6 };
		
		// enhanced for loop
		for(int i : a) { System.out.println(i); }

	}	// end of main	
	
}

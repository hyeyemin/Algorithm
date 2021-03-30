package com.ssafy.day02;

import java.util.Scanner;

public class SW_D4_1210_Ladder {
	static int[][] arr = new int[100][100];
	static int result = 0;
	static boolean checked[][] = new boolean[100][100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			tc = sc.nextInt();
			int dest_j = 0;
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 2) {
						dest_j = j;
					}
				}
			}
			find(99, dest_j);
			System.out.println("#" + tc + " " + result);
			checked = new boolean[100][100];
		}
	}
	private static void find(int i, int j) {
		if(i == 0) {
			result = j;
			return;
		}
		if(j-1 > 0 && !checked[i][j-1]) {
			if(arr[i][j-1] == 1) {
				checked[i][j-1] = true;
				find(i, j-1);
			}
		}
		if(j + 1 < 100 && !checked[i][j+1]) {
			if(arr[i][j+1] == 1) {
				checked[i][j+1] = true;
				find(i, j+1);
			}
		}
		if(arr[i-1][j] == 1 && !checked[i-1][j]) {
			checked[i-1][j] = true;
			find(i-1, j);
			for(int k = 0; k < 100; k++) {
				checked[i-1][k] = true;
			}
		}
	}
}

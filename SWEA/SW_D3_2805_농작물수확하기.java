package com.ssafy.day03;

import java.util.Scanner;

public class SW_D3_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			sc.nextLine();
			for(int i = 0; i < N; i++) {
				char[] temp = sc.nextLine().toCharArray();
				for(int j = 0; j < N; j++) {
					arr[i][j] = temp[j] - '0';
				}
			}
			int result = 0;
			boolean plus = true;
			for(int i = 0; i < N; i++) {
				if(plus) {
					for(int j = N/2 - i; j <= N/2 + i; j++) {
						result += arr[i][j];
					}
				}
				else {
					for(int j = N/2 - (N-i) + 1; j < N/2 + (N-i); j++) {
						result += arr[i][j];
					}
				}
				if(N/2 <= i) {
					plus = false;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}

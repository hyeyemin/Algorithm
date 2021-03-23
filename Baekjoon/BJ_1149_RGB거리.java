package com.ssafy.day19;

import java.util.Scanner;

public class BJ_1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N+1][3];
		int[][] D = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		D[1][0] = arr[1][0];
		D[1][1] = arr[1][1];
		D[1][2] = arr[1][2];
		for(int i = 2; i <= N; i++) {
			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + arr[i][0];
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + arr[i][1];
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + arr[i][2];
		}
		System.out.println(Math.min(Math.min(D[N][0], D[N][1]), D[N][2]));
	}
}

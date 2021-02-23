package com.ssafy.day13;

import java.util.Scanner;

public class SW_11387_D3_몬스터사냥 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int D = sc.nextInt();
			int L = sc.nextInt();
			int N = sc.nextInt();
			double result = 0;
			for(int i = 1; i <= N; i++) {
				result += (double)D * ( 1 + (double)(i-1) * ((double)L / 100.0));  
			}
			System.out.printf("#%d %.0f\n", t, result);
		}
	}
}

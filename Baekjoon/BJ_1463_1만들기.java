package com.ssafy.day19;

import java.util.Scanner;

public class BJ_1463_1만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] D = new int[1000001];
		for(int i = 1; i <= n; i++) {
			D[i] = Integer.MAX_VALUE;
		}
		D[1] = 0;
		D[2] = 1;
		D[3] = 1;
		for(int i = 4; i <= n; i++) {
			if(i % 3 == 0) D[i] = Math.min(D[i/3]+1, D[i]);
			if(i % 2 == 0) D[i] = Math.min(D[i/2]+1, D[i]);
			D[i] = Math.min(D[i], D[i-1]+1);
		}
		System.out.println(D[n]);
	}
}

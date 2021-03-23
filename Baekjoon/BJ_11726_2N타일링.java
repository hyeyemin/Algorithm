package com.ssafy.day19;

import java.util.Scanner;

public class BJ_11726_2N타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] D = new int[1001];
		D[1] = 1;
		D[2] = 2;
		for(int i = 3; i <= n; i++) {
			D[i] = (D[i-2] + D[i-1]) % 10007;
		}
		System.out.println(D[n]);
	}
}

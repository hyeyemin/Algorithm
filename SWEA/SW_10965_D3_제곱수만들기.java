package com.ssafy.day13;

import java.util.Scanner;

public class SW_10965_D3_제곱수만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 3100;
		boolean[] prime = new boolean[max + 1];
		int T = sc.nextInt();
		for(int i = 3; i <= max; i += 2) {
			int temp = i;
			if(!prime[i]) {
				while(i * temp <= max) {
					prime[i * temp] = true;
					temp += 2;
				}
			}
		}
		for(int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			
			for(int i = 2; i <= max;) {
				if(!prime[i] && a % (i*i) == 0) a /= (i*i);
				else if(i == 2) i++;
				else i+= 2;
			}
			System.out.println("#t" + t + " " + a);
		}
	}
}

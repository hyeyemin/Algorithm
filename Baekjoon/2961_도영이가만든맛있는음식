package com.ssafy.day09;

import java.util.Scanner;

public class BJ_2961_도영이가만든맛있는음식 {
	static Food[] foods, newArr;
	static int N, min;
	
	static class Food{
		int sour;
		int bitter;
		public Food(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		foods = new Food[N];
		newArr = new Food[N];
		for(int i = 0; i < N; i++) {
			foods[i] = new Food(sc.nextInt(), sc.nextInt());
		}
		min = 9999999;
		for(int i = 1; i <= N; i++) {
			combi(0, 0, i);
		}
		System.out.println(min);
	}
	private static void combi(int cnt, int start, int M) {
		if(cnt == M) {
			int sourTotal = 1;
			int bitterTotal = 0;
			for(Food f : newArr) {
				if(f != null) {
					sourTotal *= f.sour;
					bitterTotal += f.bitter;
				}
			}
			if(min >= Math.abs(sourTotal-bitterTotal)) 
				min = Math.abs(sourTotal-bitterTotal);
			return;
		}
		for(int i = start; i < N; i++) {
			newArr[cnt] = foods[i];
			combi(cnt+1, i+1, M);
		}
	}
	
}

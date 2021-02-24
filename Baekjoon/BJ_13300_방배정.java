package com.ssafy.day13;

import java.util.Scanner;

public class BJ_13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		int[][] area = new int[7][2];
		for(int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			if(area[y][s] >= k) {
				result++;
				area[y][s] = 0;
			}else if(area[y][s] == 0){
				result++;
			}
			area[y][s]++;
		}
		System.out.println(result);
	}
}

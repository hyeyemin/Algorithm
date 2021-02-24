package com.ssafy.day13;

import java.util.Scanner;

public class BJ_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] area = new int[101][101];
		for(int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for(int j = x; j < x + width; j++) {
				for(int k = y; k < y + height; k++ ) {
					area[j][k] = i;
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			int result = 0;
			for(int j = 0; j < area.length; j++) {
				for(int k = 0; k < area[j].length; k++) {
					if(area[j][k] == i) result++;
				}
			}
			System.out.println(result);
		}
	}
}

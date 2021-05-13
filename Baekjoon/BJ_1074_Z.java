package com.ssafy.day10;

import java.util.Scanner;

public class BJ_1074_Z {
	static int r,c,count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int size = (int)Math.pow(2, N);
		Z(0, 0, size);
	}
	private static void Z(int startX, int startY, int size) {
		if(size == 1) {
			if(startX == r && startY == c) {
				System.out.println(count);
			}
			count++;
			return;
		}
		
		int s = size/2;
		Z(startX, startY, s);
		Z(startX, startY+s, s);
		Z(startX+s, startY, s);
		Z(startX+s, startY+s, s);
	}
	
}

package com.ssafy.day13;

import java.util.Scanner;

public class SW_1493_D3_수의새로운연산 {
	static class Loc{
		int x, y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			Loc pLoc = calculate(p);
			Loc qLoc = calculate(q);
			Loc resultLoc = new Loc(pLoc.x + qLoc.x, pLoc.y + qLoc.y);
			System.out.println("#" + t + " " + calculate(resultLoc));
		}
	}
	private static Loc calculate(int p) {
		int count = 1;
		for(int i = 1;; i ++) {
			for(int x = 1, y = i; x <= i; x++, y--) {
				if(p == count) {
					return new Loc(x, y);
				}
				count++;
			}
		}
	}
	private static int calculate(Loc l) {
		int count = 1;
		for(int i = 1;; i++) {
			for(int x = 1, y = i; x <= i; x++, y--) {
				if(x == l.x && y == l.y) {
					return count;
				}
				count++;
			}
		}
	}
}

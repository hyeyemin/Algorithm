package com.ssafy.day23;

import java.util.Scanner;

public class BJ_2564_경비원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();
		int[][] store = new int[n][2];
		for(int i = 0; i < n; i++) {
			store[i][0] = sc.nextInt();
			store[i][1] = sc.nextInt();
		}
		int dir = sc.nextInt();
		int x = sc.nextInt();
		int result = 0;
		for(int i = 0; i < n; i++) {
			if(store[i][0] == dir) result += Math.abs(x - store[i][1]);
			else if(dir == 1) {
				if(store[i][0] == 2) {
					result += h + Math.min(x + store[i][1], (w-x) + (w-store[i][1]));
				}
				if(store[i][0] == 3) {
					result += store[i][1] + x;
				}
				if(store[i][0] == 4) {
					result += store[i][1] + w-x;
				}
			}
			else if(dir == 2) {
				if(store[i][0] == 1) {
					result += h + Math.min(x + store[i][1], (w-x) + (w-store[i][1]));
				}
				if(store[i][0] == 3) {
					result += h-store[i][1] + x;
				}
				if(store[i][0] == 4) {
					result += h-store[i][1] + w-x;
				}
			}
			else if(dir == 3) {
				if(store[i][0] == 1) {
					result += store[i][1] + x;
				}
				if(store[i][0] == 2) {
					result += store[i][1] + h-x ;
				}
				if(store[i][0] == 4) {
					result += w + Math.min(x + store[i][1], (h-x) + (h-store[i][1]));
				}
			}
			else if(dir == 4) {
				if(store[i][0] == 1) {
					result += w-store[i][1] + x;
				}
				if(store[i][0] == 2) {
					result += w-store[i][1] + h-x ;
				}
				if(store[i][0] == 3) {
					result += w + Math.min(x + store[i][1], (h-x) + (h-store[i][1]));
				}
			}
		}
		System.out.println(result);
	}
}

package com.ssafy.day05;

import java.util.Scanner;

public class SW_1861_D4_정사각형방 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, result, max, resultX, resultY;
	static int[][] area;
	static int[] resultArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			area = new int[N][N];
			max = 0; resultX = 0; resultY = 0;
			resultArr = new int[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					result = 1;
					move(i, j);
					if(max <= result) {
						if(max == result) {
							if(area[i][j] <= area[resultX][resultY]) {
								resultX = i;
								resultY = j;
							}
						}else {
							resultX = i;
							resultY = j;
						}
						max = result;
					}
				}
			}
			System.out.println("#" + t + " " + area[resultX][resultY] + " " + max);
		}
	}
	private static void move(int currX, int currY) {
		for(int i = 0; i < 4; i++) {
			int nX = currX + dx[i];
			int nY = currY + dy[i];
			if(nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
			if(area[nX][nY] -1 == area[currX][currY]) {
				result++;
				move(nX, nY);
			}else continue;
		}
		
	}
}

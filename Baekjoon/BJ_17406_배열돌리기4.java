package com.ssafy.day08;

import java.util.Scanner;

public class BJ_17406_배열돌리기4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[][] area = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				area[i][j] = sc.nextInt();
			}
		}
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		for(int k = 0; k < K; k++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			for(int n = 0; n < s; n++) {
				int temp = area[r-s-1+n][c-s-1+n];
				int currX = r-s-1+n;
				int currY = c-s-1+n;
				int i = 0;
				while(i < 4) {
					int nx = currX + dx[i];
					int ny = currY + dy[i];
					
					if(nx >= r+s-n || ny >= c+s-n || nx < r-s+n || ny < c-s+n) i++;
					else {
						area[currX][currY] = area[nx][ny];
						currX = nx;
						currY = ny;
					}
				}
				area[r-s-1][r-s] = temp;
			}
		}
		int min = 5000;
		for(int i = 0; i < N; i++) {
			int result = 0;
			for(int j = 0; j < M; j++) {
				result += area[i][j];
				System.out.print(area[i][j] + " ");
			}
			min = Math.min(min, result);
			System.out.println();
		}
		System.out.println(min);
	}
}

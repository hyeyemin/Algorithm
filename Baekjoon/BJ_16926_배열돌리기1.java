package com.ssafy.day08;

import java.util.Scanner;

public class BJ_16926_배열돌리기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] area = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				area[i][j] = sc.nextInt();
			}
		}
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int spinNum = Math.min(N, M) / 2;
		for(int r = 0; r < R; r++) {
			for(int n = 0; n < spinNum; n++) {
				int temp = area[n][n];
				int currX = n;
				int currY = n;
				int k = 0;
				while(k < 4) {
					int nx = currX + dx[k];
					int ny = currY + dy[k];
					
					if(nx >= N-n || ny >= M-n || nx < n || ny < n) k++;
					else {
						area[currX][currY] = area[nx][ny];
						currX = nx;
						currY = ny;
					}
				}
				area[n+1][n] = temp;
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}
	}
}

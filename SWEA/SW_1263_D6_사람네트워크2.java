package com.ssafy.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1263_D6_사람네트워크2 {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N  = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0) map[i][j] = 9999999;
				}
			}
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if(i==k) continue;
					for(int j = 0; j < N; j++) {
						if(i==j || k==j) continue;
						if(map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				int temp = 0;
				for(int j = 0; j < N; j++) {
					temp += map[i][j];
				}
				min = Math.min(min, temp);
			}
			System.out.println("#" + t + " " + min);
		}
		
	}
}

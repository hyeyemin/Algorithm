package com.ssafy.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n+2][2];
			int[][] dist = new int[n+2][n+2];
			boolean[][] D = new boolean[n+2][n+2];
			for(int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < n+2; i++) {
				for(int j = 0; j < n+2; j++) {
					dist[i][j] = Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]);
					if(dist[i][j] <= 50 * 20) D[i][j] = true;
				}
			}
			
			for(int k = 0; k < n+2; k++) {
				for(int i = 0; i < n+2; i++) {
					if(i == k) continue;
					for(int j = 0; j < n+2; j++) {
						if(i == j || k == j) continue;
						if(D[i][k] && D[k][j]) D[i][j] = true;
					}
				}
			}
			System.out.println(D[0][n+1] ? "happy" : "sad");
		}
	}
}

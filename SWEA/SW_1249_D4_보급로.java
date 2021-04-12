package com.ssafy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1249_D4_보급로 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] map, result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = new int[N][N];
			min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				Arrays.fill(result[i], Integer.MAX_VALUE);
			}
			for(int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = temp[j]-'0';
				}
			}
			bfs();
			System.out.println("#" + t + " " + min);
		}
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		result[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int c_x = current[0];
			int c_y = current[1];
			
			if(c_x == N-1 && c_y == N-1) min = Math.min(min, result[N-1][N-1]);
			
			for(int i = 0; i < 4; i++) {
				int nx = c_x + dx[i];
				int ny = c_y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(result[nx][ny] > result[c_x][c_y] + map[nx][ny]) {
					q.add(new int[] {nx, ny});
					result[nx][ny] = result[c_x][c_y] + map[nx][ny];
				}
			}
		}
	}
}

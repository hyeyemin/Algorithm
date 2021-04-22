package com.ssafy.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1868_파핑파핑지뢰찾기 {
	static int N;
	static int d[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.' && check(i,j)) {
						map[i][j] = 'x';
						poping(i,j);
						result++;
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.') result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
	private static boolean check(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[nx][ny] == '*') return false;
		}
		return true;
	}
	private static void poping(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = c[0] + d[i][0];
				int ny = c[1] + d[i][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
				map[nx][ny] = 'x';
				if(check(nx,ny)) {
					q.add(new int[] {nx,ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
}

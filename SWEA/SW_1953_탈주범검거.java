package com.ssafy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953_탈주범검거 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static boolean[][] visit;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			move(R,C,L);
			
			int result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(visit[i][j]) result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
	private static void move(int x, int y, int time) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y,1});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cx = current[0];
			int cy = current[1];
			int ct = current[2];
 			int dir = map[cx][cy];
			
 			if(ct == time) return;
 			
			for(int i = 0; i < 4; i++) {
				if(dir == 2) if(i > 1) continue;
				if(dir == 3) if(i < 2) continue;
				if(dir == 4) if(i == 1 || i == 2) continue;
				if(dir == 5) if(i == 0 || i == 2) continue;
				if(dir == 6) if(i == 0 || i == 3) continue;
				if(dir == 7) if(i == 1 || i == 3) continue;
				int nx = dx[i] + cx;
				int ny = dy[i] + cy;
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visit[nx][ny]) continue;
				if(i == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)) continue;
				if(i == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)) continue;
				if(i == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)) continue;
				if(i == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)) continue;
				visit[nx][ny] = true;
				q.add(new int[] {nx, ny, ct+1});
			}
		}
	}
}

package com.ssafy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {
	static int M, N, max;
	static int[][] area;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		area = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] == 1) {
					queue.add(new int[] {i,j,0});
					visit[i][j] = true;
				}
			}
		}
		bfs();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(area[i][j] == 0) {
					max = -1;
					break;
				}
			}
		}
		System.out.println(max);
		
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			int[] c = queue.poll();
			max = Math.max(max, c[2]);
			
			for(int i = 0; i < 4; i++) {
				int nx = c[0] + dx[i];
				int ny = c[1] + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) continue;
				if(area[nx][ny] == 0) {
					queue.add(new int[] {nx, ny, c[2] + 1});
					area[nx][ny] = 1;
					visit[nx][ny] = true;
				}
			}
		}
	}
}

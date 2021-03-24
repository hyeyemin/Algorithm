package com.ssafy.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	static int n, m, count, time, lastCount;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	static int[][] area;
	static boolean[][] melting;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		area = new int[n][m];
		visit = new boolean[n][m];
		melting = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] == 1) count++;
			}
		}
		while(count != 0) {
			lastCount = count;
			melt();
			checkCount();
			time++;
			visit = new boolean[n][m];
		}
		System.out.println(time);
		System.out.println(lastCount);
	}
	private static void melt() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) continue;
				if(area[nx][ny] == 1) melting[nx][ny] = true;
				if(area[nx][ny] == 0) queue.add(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}
	}
	private static void checkCount() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(melting[i][j]) {
					area[i][j] = 0;
					count--;
					if(count == 0) return;
					melting[i][j] = false;
				}
			}
		}
	}
	
}

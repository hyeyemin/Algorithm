package com.ssafy.day20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1600_말이되고픈원숭이 {
	static int K,W,H, min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visit;
	//원숭 움직임
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	//말 움직임
	static int hx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int hy[] = {-2, -2, 1, 2, -2, -1, 1, 2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		visit = new boolean[H][W][100];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		move();
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	private static void move() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,0,0,0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int dist = current[2];
			int kCount = current[3];
			int v = current[4];
			if(current[0] == H-1 && current[1] == W-1) {
				min = Math.min(min, dist);
				break;
			}
			if(kCount < K) {
				for(int i = 0; i < 8; i++) {
					int nx = current[0] + hx[i];
					int ny = current[1] + hy[i];
					if(nx < 0 || ny < 0 || nx >= H || ny >= W  || visit[nx][ny][v+1]|| map[nx][ny] == 1) continue;
					queue.add(new int[] {nx, ny, dist+1, kCount+1, v+1});
					visit[nx][ny][v+1] = true;
				}
			}
			for(int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				if(nx < 0 || ny < 0 || nx >= H || ny >= W || visit[nx][ny][v] || map[nx][ny] == 1) continue;
				queue.add(new int[] {nx, ny, dist+1, kCount, v});
				visit[nx][ny][v] = true;
			}
			
		}
	}
}

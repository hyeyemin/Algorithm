package com.ssafy.day22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_14502_연구소 {
	static int[][] map, copyMap;
	static int N, M, max;
	static int[][] newArr = new int[3][2];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> queue;
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		perm(0);
		System.out.println(max);
	}
	private static void perm(int cnt) {
		if(cnt == 3) {
			copy();
			queue = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2) bfs(i, j);
				}
			}
			count();
			return;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) continue;
				map[i][j] = 1;
				perm(cnt+1);
				map[i][j] = 0;
			}
		}
	}
	static void copy() {
		copyMap = new int[N][];
		for (int i = 0; i < N; i++) {
			copyMap[i] = Arrays.copyOf(map[i], M);
		}
	}
	private static void bfs(int i, int j) {
		queue.add(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int current[] = queue.poll();
			
			for(int k = 0; k < 4; k++) {
				int nx = current[0] + dx[k];
				int ny = current[1] + dy[k];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M ||copyMap[nx][ny] != 0) continue;
				queue.add(new int[] {nx,ny});
				copyMap[nx][ny] = 2;
			}
		}
	}
	private static void count() {
		int temp = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) temp++;
			}
		}
		max = Math.max(temp, max);
	}
}

package com.ssafy.day15;

import java.util.Scanner;

public class BJ_17136_색종이붙이기 {
	static int[][] map;
	static boolean[][] visited;
	static int minPaper = Integer.MAX_VALUE;
	static int[] paper;
	static class Loc{
		int x, y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		visited = new boolean[10][10];
		paper = new int[] {5, 5, 5, 5, 5};
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		check();
		if(minPaper == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minPaper);
	}
	private static void check() {
		Loc temp = findStart();
		int nx = temp.x;
		int ny = temp.y;
		if(nx == -1 && ny == -1) {
			int min = 0;
			for(int i = 0; i < 5; i++) {
				min += (5 - paper[i]);
			}
			minPaper = Math.min(minPaper, min);
			return;
		}
		
		for(int i = 5; i >= 1; i--) {
			if(paper[i-1] > 0) {
				paper[i-1]--;
				if(Available(nx, ny, i)) {
					fill(nx, ny, i, true);
					check();
					fill(nx, ny, i, false);
				};
				paper[i-1]++;
			}
		}
	}
	private static void fill(int nx, int ny, int k, boolean b) {
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				visited[nx+ i][ny + j] = b;
			}
		}
	}
	private static boolean Available(int nx, int ny, int k) {
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				if(nx + i >= 10 || ny + j >= 10 || map[nx+i][ny+j] == 0 || visited[nx+i][ny+j]) return false;
			}
		}
		return true;
	}
	private static Loc findStart() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 1 && !visited[i][j]) return new Loc(i,j);
			}
		}
		return new Loc(-1,-1);
	}
}

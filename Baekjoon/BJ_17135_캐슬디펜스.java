package com.ssafy.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_17135_캐슬디펜스 {
	static int N, M, D, max;
	static int[] loc = new int[3];
	static int[][] map, original;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N+1][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		original = new int[N+1][M];
		for(int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, original[i], 0, M);
		}
		combi(0,0);
		System.out.println(max);
	}
	private static void combi(int start, int cnt) {
		if(cnt == 3) {
			for(int i = 0; i < N; i++) {
				System.arraycopy(original[i], 0, map[i], 0, M);
			}
			max = Math.max(max, game());
			return;
		}
		for(int i = start; i < M; i++) {
			loc[cnt] = i;
			combi(i+1, cnt+1);
		}
	}
	private static int game() {
		int result = 0;
		for(int n = N; n > 0; n--) {
			int[][] enemy = new int[3][2];
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					enemy[i][j] = -1;
				}
			}
			for(int k = 0; k < 3; k++) {
				ArrayList<int[]> list = new ArrayList<>();
				for(int i = n-1; i >= 0; i--) {
					for(int j = 0; j < M; j++) {
						if(map[i][j] == 0) continue;
						int l = dist(n, loc[k], i, j);
						if(l <= D) list.add(new int[] {i,j,l});
					}
				}
				if(list.size() == 0) continue;
				int min = Integer.MAX_VALUE;
				int minx = -1, miny = -1;
				for(int i = 0; i < list.size(); i++) {
					if(min >= list.get(i)[2]) {
						if(min == list.get(i)[2]) {
							if(list.get(i)[1] < miny) {
								minx = list.get(i)[0];
								miny = list.get(i)[1];
								min = list.get(i)[2];
							}
						}else {
							minx = list.get(i)[0];
							miny = list.get(i)[1];
							min = list.get(i)[2];
						}
					}
				}
				enemy[k][0] = minx;
				enemy[k][1] = miny;
			}
			for(int i = 0; i < 3; i++) {
				if(enemy[i][0] == -1) continue;
				if(map[enemy[i][0]][enemy[i][1]] != 0) {
					map[enemy[i][0]][enemy[i][1]] = 0;
					result++;
				}
			}
		}
		return result;
	}
	private static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}

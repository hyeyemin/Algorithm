package com.ssafy.day16;

import java.util.Scanner;

public class BJ_14889_스타트와링크 {
	static int N, min = Integer.MAX_VALUE;
	static int map[][];
	static int team1[], team2[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		team1 = new int[N/2];
		team2 = new int[N/2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		combi(0,0);
		System.out.println(min);
	}
	private static void combi(int start, int cnt) {
		if(cnt == N/2) {
			int num = 0;
			boolean[] visited = new boolean[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < team1.length; j++) {
					if(team1[j] == i) visited[i] = true;
				}
			}
			for(int i = 0; i < N; i++) {
				if(!visited[i]) team2[num++] = i;
			}
			min = Math.min(Math.abs(check(team1)-check(team2)), min);
			return;
		}
		for(int i = start; i < N; i++) {
			team1[cnt] = i;
			combi(i+1, cnt+1);
		}
	}
	private static int check(int[] arr) {
		int result = 0;
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				if(i != j)	result += map[arr[i]][arr[j]];
			}
		}
		return result;
	}
}

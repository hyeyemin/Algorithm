package com.ssafy.day12;

import java.util.ArrayList;
import java.util.Scanner;

public class SW_1247_D5_최적경로 {
	static class Loc{
		int x, y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, min = Integer.MAX_VALUE;
	static Loc[] newArr;
	static Loc company, home;
	static ArrayList<Loc> customers;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			company = new Loc(sc.nextInt(), sc.nextInt());
			home = new Loc(sc.nextInt(), sc.nextInt());
			newArr = new Loc[N];
			visited = new boolean[N];
			customers = new ArrayList<>();
			min = Integer.MAX_VALUE;
			for(int n = 0; n < N; n++) {
				customers.add(new Loc(sc.nextInt(), sc.nextInt()));
			}
			perm(0);
			System.out.println("#" + t + " " + min);
		}
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			int result = calculate(company, newArr[0]);
			for(int i = 0; i < N-1; i++) {
				result += calculate(newArr[i], newArr[i+1]);
			}
			result += calculate(newArr[N-1], home);
			min = Math.min(min, result);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			newArr[cnt] = customers.get(i);
			perm(cnt+1);
			visited[i] = false;
		}
	}
	private static int calculate(Loc l1, Loc l2) {
		return Math.abs(l1.x - l2.x) + Math.abs(l1.y - l2.y);
	}
}

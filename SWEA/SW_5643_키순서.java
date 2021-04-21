package com.ssafy.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_5643_키순서 {
	static ArrayList<Integer>[] list;
	static int[] cnts;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			cnts = new int[N+1];
			list = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
			}
			for(int i = 1; i <= N; i++) {
				visit = new boolean[N+1];
				check(i, i);
			}
			int result = 0;
			for(int i = 1; i <= N; i++) {
				if(cnts[i] == N-1) result++; 
			}
			System.out.println("#" + t + " " + result);
		}
	}
	private static void check(int start, int x) {
		visit[x] = true;
		for(int i = 0; i < list[x].size(); i++) {
			if(!visit[list[x].get(i)]) {
				cnts[start]++;
				cnts[list[x].get(i)]++;
				check(start, list[x].get(i));
			}
		}
	}
}

package com.ssafy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4014_활주로건설 {
	static int N, X, result;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve();
			System.out.println("#" + t + " " + result);
		}
	}
	private static void solve() {
		for(int i = 0; i < N; i++) {
			if(makeRoadByRow(i)) result++;
			if(makeRoadByCol(i)) result++;
		}
		
	}
	private static boolean makeRoadByRow(int i) {
		int beforeHeight = map[i][0];
		int size = 0;
		int j = 0; //탐색 열 위치
		while(j < N) {
			if(beforeHeight == map[i][j]) {
				size++;
				j++;
			}
			else if(beforeHeight + 1 == map[i][j]) {
				if(size < X) return false;
				beforeHeight++;
				size = 1;
				j++;
			}
			else if(beforeHeight == map[i][j] + 1) {
				int count = 0;
				for(int k = j; k < N; k++) {
					if(map[i][k] != beforeHeight-1) break;
					if(++count == X) break;
				}
				if(count < X) return false;
				beforeHeight--;
				size = 0;
				j += X;
			}
			else return false;
		}
		return true;
	}
	private static boolean makeRoadByCol(int i) {
		int beforeHeight = map[0][i];
		int size = 0;
		int j = 0; //탐색 열 위치
		while(j < N) {
			if(beforeHeight == map[j][i]) {
				size++;
				j++;
			}
			else if(beforeHeight + 1 == map[j][i]) {
				if(size < X) return false;
				beforeHeight++;
				size = 1;
				j++;
			}
			else if(beforeHeight == map[j][i] + 1) {
				int count = 0;
				for(int k = j; k < N; k++) {
					if(map[k][i] != beforeHeight-1) break;
					if(++count == X) break;
				}
				if(count < X) return false;
				beforeHeight--;
				size = 0;
				j += X;
			}
			else return false;
		}
		return true;
	}
	
}

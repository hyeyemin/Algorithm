package com.ssafy.homework20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1987_알파벳 {
	static int r, c, result, max;
	static char[][] board;
	static boolean[] visited = new boolean[26];
	static boolean[][] visitedLoc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		r = Integer.parseInt(s.split(" ")[0]);
		c = Integer.parseInt(s.split(" ")[1]);
		board = new char[r][c];
		visitedLoc = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			s = br.readLine();
			board[i] = s.toCharArray();
		}
		move(0, 0);
		System.out.println(max);
	}
	private static void move(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		if(!check(x,y)) {
			max = Math.max(count(), max);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			if(visitedLoc[nx][ny]) continue;
			visitedLoc[x][y] = true;
			visited[board[x][y] - 65] = true;
			visitedLoc[nx][ny] = true;
			if(all()) max = r * c;
			else visitedLoc[nx][ny] = false;
			move(nx, ny);
			visitedLoc[x][y] = false;
			visited[board[x][y] - 65] = false;
		}
	}
	private static boolean check(int x, int y) {
		if(visited[board[x][y] - 65]) return false;
		return true;
	}
	private static int count() {
		int result = 0;
		for(int i = 0; i < 26; i++) {
			if(visited[i] == true)  result++;
		}
		return result;
	}
	private static boolean all() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!visitedLoc[i][j]) return false;
			}
		}
		return true;
	}
}

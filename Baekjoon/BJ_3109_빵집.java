package com.ssafy.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3109_빵집 {
	static int r, c, result;
	static boolean isReturn;
	static char[][] area;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		r = Integer.parseInt(s.split(" ")[0]);
		c = Integer.parseInt(s.split(" ")[1]);
		area = new char[r][c];
		visited = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			s = br.readLine();
			area[i] = s.toCharArray();
		}
		for(int i = 0; i < r; i++) {
			setPipe(i,0);
		}
		System.out.println(result);
	}
	private static void setPipe(int x, int y) {
		if(!check(x,y)) {
			return;
		}
		if(y == c-1) {
			result++;
			isReturn = true;
			return;
		}
		for(int i = -1; i < 2; i++) {
			if(y == 0) isReturn = false;
			if(isReturn) return;
			if(x+i < 0 || x+i >= r) continue;
			setPipe(x+i, y+1);
		}
	}
	private static boolean check(int x, int y) {
		if(area[x][y] == 'x') return false;
		else{
			if(!visited[x][y]) {
				visited[x][y] = true;
				return true;
			}else
				return false;
		}
	}
}

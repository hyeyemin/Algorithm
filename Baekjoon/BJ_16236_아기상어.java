package com.ssafy.day15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_16236_아기상어 {
	static int N, result, sx, sy;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Loc> list;
	static class Loc{
		int x, y, dist;
		Loc(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}
		System.out.println(go());
	}
	private static int go() {
		int size = 2;
		int count = 0;
		while(true) {
			boolean visited[][] = new boolean[N][N];
			Queue<Loc> queue = new LinkedList<>();
			list = new ArrayList<>();
			queue.offer(new Loc(sx, sy, 0));
			visited[sx][sy] = true;
			
			while(!queue.isEmpty()) {
				Loc current = queue.poll();
				for(int k = 0; k < 4; k++) {
					int nx = dx[k] + current.x;
					int ny = dy[k] + current.y;
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
					Loc next = new Loc(nx, ny, current.dist+1);
					visited[nx][ny] = true;
					if(map[nx][ny] > 0 && map[nx][ny] < size) {
						list.add(next);
						queue.offer(next);
					}else if(map[nx][ny] == size || map[nx][ny] == 0) {
						queue.offer(next);
					}
				}
			}
			if(list.size() == 0) return result;
			
			Loc fish = list.get(0);
			for(int i = 1; i < list.size(); i++) {
				if(list.get(i).dist < fish.dist) fish = list.get(i);
				if(list.get(i).dist == fish.dist) {
					if(list.get(i).x < fish.x) fish = list.get(i);
				}
			}
			result += fish.dist;
			count++;
			map[fish.x][fish.y] = 0;
			if(count == size) {
				size++;
				count = 0;
			}
			sx = fish.x;
			sy = fish.y;
		}
	}
}

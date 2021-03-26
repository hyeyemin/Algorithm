package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17472_다리만들기2 {
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	static int N, M, number;
	static Queue<int[]> queue;
	static ArrayList<Edge> list;
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int dist;
		Edge(int a, int b, int dist){
			this.a = a;
			this.b = b;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					makeIsland(++number, i, j); 
					map[i][j] = number;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					makeRoad(map[i][j],i,j,1,0);
					makeRoad(map[i][j],i,j,2,0);
				}
			}
		}
		parent = new int[number+1];
		for(int i = 1; i <= number; i++) {
			parent[i] = i;
		}
		Collections.sort(list);
		int total = 0;
		for(int i = 0; i < list.size(); i++) {
			if(find(list.get(i).a) != find(list.get(i).b)) {
				total += list.get(i).dist;
				union(list.get(i).a, list.get(i).b);
			}
		}
		
		for(int i = 1; i < number; i++) {
			if(parent[i] != parent[i+1]) {
				total = -1;
				break;
			}
		}
		System.out.println(total);
		
	}
	private static void makeIsland(int num, int i, int j) {
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || map[nx][ny] != 1) continue;
			visit[nx][ny] = true;
			map[nx][ny] = num;
			makeIsland(num, nx, ny);
		}
	}
	private static void makeRoad(int start, int x, int y, int dir, int dist) {
		if(dir == 1) {
			int nx = x+1;
			if(nx < N && map[nx][y] == 0) makeRoad(start, nx, y, dir, dist+1);
			else if(nx < N && map[nx][y] != 0){
				int end = map[nx][y];
				if(dist >= 2) {
					list.add(new Edge(start,end, dist));
				}
			}
		}
		if(dir == 2) {
			int ny = y+1;
			if(ny < M && map[x][ny] == 0) makeRoad(start, x, ny, dir, dist+1);
			else if(ny < M && map[x][ny] != 0){
				int end = map[x][ny];
				if(dist >= 2) {
					list.add(new Edge(start,end,dist));
				}
			}
		}
	}
	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x < y) {
			parent[y] = x;
			for(int i = 0; i < parent.length; i++) {
				if(parent[i] == y) parent[i] = x;
			}
		}
		else {
			parent[x] = y;
			for(int i = 0; i < parent.length; i++) {
				if(parent[i] == x) parent[i] = y;
			}
		}
	}
	private static int find(int x) {
		if(parent[x] == x) return x;
		else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}
}

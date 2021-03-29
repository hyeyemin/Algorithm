package com.ssafy.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1251_D4_하나로 {
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		double cost;
		
		Edge(int a, int b){
			this.a = a;
			this.b = b;
			this.cost = getCost();
		}
		
		private double getCost() {
			double w = yArr[this.a] - yArr[this.b];
			double h = xArr[this.a] - xArr[this.b];
			return Math.sqrt(w*w + h*h);
		}

		@Override
		public int compareTo(Edge o) {
			if(this.cost < o.cost) {
				return -1;
			}else if(this.cost > o.cost) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	static int[] parent;
	static int[] xArr;
	static int[] yArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			parent = new int[N];
			xArr = new int[N];
			yArr = new int[N];
			for(int i = 0; i < N; i++) {
				parent[i] = i;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				xArr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				yArr[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			
			Edge[] edge = new Edge[N*(N-1) / 2];
			int num = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					edge[num++] = new Edge(i,j);
				}
			}
			Arrays.sort(edge);
			double total = 0;
			for(int i = 0; i < edge.length; i++) {
				if(find(edge[i].a) != find(edge[i].b)) {
					total += E * edge[i].cost * edge[i].cost;
					union(edge[i].a, edge[i].b);
				}
			}
			System.out.println("#" + t + " " + Math.round(total));
		}
	}
	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	private static int find(int x) {
		if(parent[x] == x) return x;
		else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}
}

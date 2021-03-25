package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리 {
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int cost;
		Edge(int a, int b, int cost){
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		parent = new int[v+1];
		for(int i = 1; i <= v; i++) {
			parent[i] = i;
		}
		int e = Integer.parseInt(st.nextToken());
		Edge[] edge = new Edge[e]; 
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			edge[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edge);
		int total = 0;
		for(int i = 0; i < e; i++) {
			if(find(edge[i].a) != find(edge[i].b)) {
				total += edge[i].cost;
				union(edge[i].a, edge[i].b);
			}
		}
		System.out.println(total);
	}
	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	private static int find(int x) {
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
}

package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_6497_전력난 {
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
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[m];
			for(int i = 0; i < m; i++) {
				parent[i] = i;
			}
			int n = Integer.parseInt(st.nextToken());
			if(m == 0 && n == 0) break;
			Edge[] edge = new Edge[n];
			int total = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edge[i] = new Edge(a, b, c);
				total += c;
			}
			Arrays.sort(edge);
			int saving = 0;
			for(int i = 0; i < n; i++) {
				if(find(edge[i].a) != find(edge[i].b)) {
					saving += edge[i].cost;
					union(edge[i].a, edge[i].b);
				}
			}
			System.out.println(total - saving);
			
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

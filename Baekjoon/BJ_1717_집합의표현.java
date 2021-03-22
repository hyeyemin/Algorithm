package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1717_집합의표현 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(oper == 0) union(a, b);
			if(oper == 1) {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x > y) {
			parent[x] = y;
		}else {
			parent[y] = x;
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

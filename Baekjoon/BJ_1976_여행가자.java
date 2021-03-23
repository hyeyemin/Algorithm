package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_여행가자 {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1)union(i,j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int[] plan = new int[M];
		for(int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		String result = "YES";
		for(int i = 1; i < M; i++) {
			if(find(plan[i-1]) != find(plan[i])) {
				result = "NO";
				break;
			}
		}
		System.out.println(result);
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

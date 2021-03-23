package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_16562_친구비 {
	static int[] money, parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		money = new int[N+1];
		for(int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int total = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if(!list.contains(parent[i])) {
				list.add(parent[i]);
				total += money[parent[i]];
			}
		}
		if(total <= k) System.out.println(total);
		else System.out.println("Oh no");
	}
	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(money[x] > money[y]) {
			for(int i = 0; i < parent.length; i++) {
				if(parent[i] == x) {
					parent[i] = y;
				}
			}
			parent[x] = y;
		}
		else {
			for(int i = 0; i < parent.length; i++) {
				if(parent[i] == y) {
					parent[i] = x;
				}
			}
			parent[y] = x;
		}
	}
	private static int find(int x) {
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
}

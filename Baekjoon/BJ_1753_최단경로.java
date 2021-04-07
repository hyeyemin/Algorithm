package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {
	static class Node implements Comparable<Node>{
		int vertex;
		int cost;
		
		Node(int vertex, int cost){
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	static ArrayList<Node>[] list;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		dijkstra(K);
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			System.out.println(dist[i]);
		}
	}
	private static void dijkstra(int k) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[dist.length];
		queue.add(new Node(k, 0));
		dist[k] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int v = current.vertex;
			if(visit[v]) continue;
			visit[v] = true;
			
			for(int i = 0; i < list[v].size(); i++) {
				if(dist[list[v].get(i).vertex] > dist[v] + list[v].get(i).cost) {
					dist[list[v].get(i).cost] = dist[v] + list[v].get(i).cost;
					queue.add(new Node(list[v].get(i).vertex, dist[list[v].get(i).vertex]));
				}
			}
		}
	}
}

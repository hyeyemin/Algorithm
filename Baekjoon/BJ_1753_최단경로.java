package com.ssafy.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {
	static class Node implements Comparable<Node>{
		int v;
		int w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
	static int V, E, K;
	private static ArrayList<Node>[] list;
	private static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		dijkstra(K);
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[V+1];
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			int curV = current.v;
			
			if(visit[curV]) continue;
			visit[curV] = true;
			
			for(int i = 0; i < list[curV].size(); i++) {
				if(dist[list[curV].get(i).v] > dist[curV] + list[curV].get(i).w) {
					dist[list[curV].get(i).v] = dist[curV] + list[curV].get(i).w;
					queue.add(new Node(list[curV].get(i).v, dist[list[curV].get(i).v]));
				}
			}
		}
	}
}

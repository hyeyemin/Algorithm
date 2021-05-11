package week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PG_72413_합승택시요금 {
	static final int MAX = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> list;
	public static void main(String[] args) {
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(6,4,6,2,fares));
	}
	public static class Edge implements Comparable<Edge>{
		int vertex;
		int cost;
		
		Edge(int vertex, int cost){
			this.vertex = vertex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++ ) {
			list.add(new ArrayList<>());
		}
		
		for(int[] i : fares){
            list.get(i[0]).add(new Edge(i[1], i[2]));
            list.get(i[1]).add(new Edge(i[0], i[2]));
        }

        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];

        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start, MAX);

        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);

        for(int i = 1; i <= n ; i++) {
        	answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }
        return answer;
    }

	private static int[] dijkstra(int start, int[] costs) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[costs.length+1];
		queue.add(new Edge(start, 0));
		costs[start] = 0;
		
		while(!queue.isEmpty()){
			Edge current = queue.poll();
			int curV = current.vertex;
			
			if(visit[curV]) continue;
			visit[curV] = true;
			
			for(int i = 0; i < list.get(curV).size(); i++) {
				if(costs[list.get(curV).get(i).vertex] > costs[curV] + list.get(curV).get(i).cost) {
					costs[list.get(curV).get(i).vertex] = costs[curV] + list.get(curV).get(i).cost;
					queue.add(new Edge(list.get(curV).get(i).vertex, costs[list.get(curV).get(i).vertex]));
				}
			}
		}
		return costs;
	}
}

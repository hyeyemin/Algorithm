package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1967_트리의지름 {
	static LinkedList<int[]>[] list;
	static int maxDist, maxVertex;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new LinkedList[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new LinkedList<>();
		}
		StringTokenizer st = null;
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[parent].add(new int[] {vertex, dist});
			list[vertex].add(new int[] {parent, dist});
		}
		visited[1] = true;
		find(1,0);
		visited = new boolean[n+1];
		find(maxVertex, 0);
		System.out.println(maxDist);
	}
	private static void find(int vertex, int dist) {
		if(maxDist < dist) {
			maxDist = dist;
			maxVertex = vertex;
		}
		for(int i = 0; i < list[vertex].size(); i++) {
			if(!visited[list[vertex].get(i)[0]]) {
				visited[list[vertex].get(i)[0]] = true;
				find(list[vertex].get(i)[0], list[vertex].get(i)[1] + dist);
				visited[list[vertex].get(i)[0]] = false;
			}
		}
	}
}

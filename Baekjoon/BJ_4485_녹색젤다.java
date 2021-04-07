package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485_녹색젤다 {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
		
	}
	static int[][] map, dist;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = 1;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			dist = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
			System.out.println("Problem " + (t++) + ": " + dist[N-1][N-1]);
		}
	}
	private static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[][] visit = new boolean[N][N];
		queue.add(new Node(0,0,map[0][0]));
		dist[0][0] = map[0][0];
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			int curi = current.x;
			int curj = current.y;
			int cost = current.cost;
			
			if(visit[curi][curj]) continue;
			visit[curi][curj] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = curi + dx[i];
				int ny = curj + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(dist[nx][ny] > cost + map[nx][ny] ){
					dist[nx][ny] = cost + map[nx][ny];
					queue.add(new Node(nx, ny, dist[nx][ny]));
				}
			}
			
		}
	}
}

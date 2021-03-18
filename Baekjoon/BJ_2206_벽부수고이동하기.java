package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_벽부수고이동하기 {
	static int N, M, minDist = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		bfs();
		if(minDist == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minDist);
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		//x,y,거리,부쉈나
		queue.add(new int[] {0,0,1,0});
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int dist = current[2];
			int use = current[3];
			
			if(x == N-1 && y == M-1) {
				minDist = Math.min(minDist, dist);
			}
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny][use]) continue;
				if(map[nx][ny] == 1 && use == 1) continue;
				if(map[nx][ny] == 1) {
					queue.add(new int[] {nx, ny, dist+1, 1});
					visited[nx][ny][1] = true;
				}
				else {
					queue.add(new int[] {nx, ny, dist+1, use});
					visited[nx][ny][use] = true;
				}
			}
			
		}
	}
}

package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토 {
	static int M, N, H, day;
	static int[][][] boxes;
	static int[][][] dist;
	//앞,뒤,좌,우,상,하
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int count0 = 0;
		boxes = new int[N][M][H];
		dist = new int[N][M][H];
		queue = new LinkedList<>();
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					boxes[i][j][h] = Integer.parseInt(st.nextToken());
					if(boxes[i][j][h] == 0) count0++; 
					if(boxes[i][j][h] == 1) queue.add(new int[] {i,j,h});
				}
			}
		}
		if(count0 == 0) System.out.println(0);
		else {
			bfs();
			check();
			System.out.println(day);
		}
	}

	private static void check() {
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(dist[i][j][h] == 0 && boxes[i][j][h] == 0) day = -1;
				}
			}
		}
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int h = temp[2];
			day = Math.max(day, dist[x][y][h]);
			
			for(int k = 0; k < 6; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				int nh = h + dh[k];
				if(nx < 0 || ny < 0 || nh < 0 || nx >= N || ny >= M || nh >= H || 
						boxes[nx][ny][nh] == 1 || boxes[nx][ny][nh] == -1) continue;
				queue.add(new int[] {nx, ny, nh});
				boxes[nx][ny][nh] = 1;
				dist[nx][ny][nh] = dist[x][y][h] + 1;
			}
		}
	}
}

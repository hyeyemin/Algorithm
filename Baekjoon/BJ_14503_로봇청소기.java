package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {
	static int[] dx = {-1,0,1,0}; //북동남서
	static int[] dy = {0,1,0,-1};
	static boolean[][] visit;
	static int[][] map;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[r][c] = true;
		clean(r,c,d);
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(visit[i][j]) result++;
			}
		}
		System.out.println(result);
	}
	private static void clean(int x, int y, int dir) {
		int left = (dir + 3) % 4;
		int nx = x + dx[left];
		int ny = y + dy[left];
		if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && map[nx][ny] == 0) {
			visit[nx][ny] = true;
			clean(nx,ny,left);
		}
		else if(check(x,y)) {
			int bx = x + dx[(dir+2)%4];
			int by = y + dy[(dir+2)%4];
			if(bx < 0 || by < 0|| bx >= n || by >= m || map[bx][by] == 1) return;
			else clean(bx,by,dir);
		}else {
			clean(x,y,left);
		}
		
	}
	private static boolean check(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && map[nx][ny] == 0) return false;
		}
		return true;
	}
}

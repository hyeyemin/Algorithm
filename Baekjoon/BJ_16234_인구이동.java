package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {
	static int[][] map;
	static boolean[][] visit;
	static int N,L,R,result;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean check;
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		list = new ArrayList[N*N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(check()) {
			visit = new boolean[N][N];
			list = new ArrayList[N*N];
			result++;
		}
		System.out.println(result);
	}
	private static boolean check() {
		boolean flag = false;
		int num = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				list[num] = new ArrayList<>();
				movecheck(i,j, num);
				if(list[num++].size() > 1) {
					flag = true;
				}
			}
		}
		move();
		return flag;
	}
	private static void movecheck(int x, int y, int num) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});

		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			list[num].add(new int[] {cx,cy});
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
				if(Math.abs(map[nx][ny] - map[cx][cy]) >= L &&  Math.abs(map[nx][ny] - map[cx][cy]) <= R) {
					visit[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	private static void move() {
		for(int k = 0; k < list.length; k++) {
			int sum = 0;
			for(int i = 0; i < list[k].size(); i++) {
				int a = list[k].get(i)[0];
				int b = list[k].get(i)[1];
				sum += map[a][b];
			}
			int result = sum / list[k].size();
			for(int i = 0; i < list[k].size(); i++) {
				int a = list[k].get(i)[0];
				int b = list[k].get(i)[1];
				map[a][b] = result;
			}
		}
	}
}

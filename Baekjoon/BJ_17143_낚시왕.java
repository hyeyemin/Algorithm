package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕 {
	static int R, C, M, total;
	static Shark[][] map;
	static ArrayList<Shark> sharks;
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		
		Shark(int r, int c, int s, int d, int z){
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R+1][C+1];
		sharks = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r,c,s,d,z); 
			sharks.add(map[r][c]);
		}
		for(int i = 1; i <= C; i++) {
			fishing(i);
			move();
		}
		System.out.println(total);
	}
	private static void fishing(int c) {
		for(int i = 0; i <= R; i++) {
			if(map[i][c] != null) {
				total += map[i][c].z;
				sharks.remove(map[i][c]);
				map[i][c] = null;
				break;
			}
		}
	}
	private static void move() {
		for(int i = 0; i < sharks.size(); i++) {
			Shark now = sharks.get(i);
			for(int j = 0; j < now.s; j++) {
				if(now.r == 1 && now.d == 1) now.d = 2;
				if(now.r == R && now.d == 2) now.d = 1;
				if(now.c == 1 && now.d == 4) now.d = 3;
				if(now.c == C && now.d == 3) now.d = 4;
				now.r += dx[now.d-1];
				now.c += dy[now.d-1];
			}
		}
		map = new Shark[R+1][C+1];
		for(int i = 0; i < sharks.size(); i++) {
			Shark now = sharks.get(i);
			if(map[now.r][now.c] != null) {
				if(map[now.r][now.c].z < now.z) {
					sharks.remove(map[now.r][now.c]);
					map[now.r][now.c] = now;
				}else {
					sharks.remove(now);
				}
				i--;
			}else {
				map[now.r][now.c] = now;
			}
		}
	}
}

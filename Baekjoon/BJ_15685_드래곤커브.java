package week10;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_15685_드래곤커브 {
	static int[][] map = new int[101][101];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			make(x, y, d, g);
		}
		int ans = 0;
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				if(map[i][j] == 0) continue;
				if(check(i, j)) ans++;
			}
		}
		System.out.println(ans);
	}
	 public static void make(int x, int y, int d, int g) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(d);

        for(int i = 0; i < g; i++) {
            for(int j = list.size() - 1; j >= 0; j--) 
            	list.add((list.get(j) + 1) % 4);
        }

        map[x][y] = 1;
        for(Integer i : list) {
            x += dx[i]; 
            y += dy[i];
            map[x][y] = 1; 
        }
    }
	private static boolean check(int x, int y) {
		if(x >= 100 || y >= 100) return false;
		if(map[x+1][y] == 1 && map[x][y+1] == 1 && map[x+1][y+1] == 1) return true;
		return false;
	}
}

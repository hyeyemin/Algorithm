package week08;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ_15683_감시 {
	static int N, M, min = Integer.MAX_VALUE;
	static int[][] map;
	static LinkedList<CCTV> list = new LinkedList<>();
	static class CCTV {
		int x;
		int y;
		int number;

		public CCTV(int x, int y, int number) {
			this.x = x;
			this.y = y;
			this.number = number;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > 0 && map[i][j] < 6) {
					list.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		solve(0);
		System.out.println(min);
	}

	private static void solve(int k) {
		if (k == list.size()) {
			int num = count();
			min = Math.min(min, num);
			return;
		}
		CCTV c = list.get(k);
		int x = c.x;
		int y = c.y;
		int n = c.number;

		int[][] temp = new int[N][M];
		switch (n) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N; j++) {
					System.arraycopy(map[j], 0, temp[j], 0, M);
				}
				spread(i, x, y);
				solve(k+1);
				for (int j = 0; j < N; j++) {
					System.arraycopy(temp[j], 0, map[j], 0, M);
				}
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
                for (int j = 0; j < temp.length; j++) {
                    System.arraycopy(map[j], 0, temp[j], 0, M);
                }
                spread(i, x, y);
                spread(i+2, x, y);
                solve(k+1);
                for (int j = 0; j < temp.length; j++) {
                    System.arraycopy(temp[j], 0, map[j], 0, M);
                }
            }
            break;
        case 3:
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < temp.length; j++) {
                    System.arraycopy(map[j], 0, temp[j], 0, M);
                }
                spread(i, x, y);
                spread((i+1) % 4, x, y);
                solve(k + 1);
                for (int j = 0; j < temp.length; j++) {
                    System.arraycopy(temp[j], 0, map[j], 0, M);
                }
            }
            break;
        case 4:
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < temp.length; j++) {
                    System.arraycopy(map[j], 0, temp[j], 0,M);
                }
                spread(i, x, y);
                spread((i+1) % 4, x, y);
                spread((i+2) % 4, x, y);
                solve(k+1);
                for (int j = 0; j < temp.length; j++) {
                    System.arraycopy(temp[j], 0, map[j], 0, M);
                }
            }
            break;
        case 5:
            for (int j = 0; j < temp.length; j++) {
                System.arraycopy(map[j], 0, temp[j], 0, M);
            }
            spread(0, x, y);
            spread(1, x, y);
            spread(2, x, y);
            spread(3, x, y);
            solve(k+1);
            for (int j = 0; j < temp.length; j++) {
                System.arraycopy(temp[j], 0, map[j], 0, M);
            }
            break;
        default:
            break;
        }
	}

	private static void spread(int dir, int x, int y) {
		if(dir == 0) {
			int nx = x - 1;
			if (nx < 0 || map[nx][y] == 6) return;
			map[nx][y] = -1;
			spread(dir, nx, y);
		}
		if(dir == 1) {
			int ny = y - 1;
			if (ny < 0 || map[x][ny] == 6) return;
			map[x][ny] = -1;
			spread(dir, x, ny);
		}
		if(dir == 2) {
			int nx = x + 1;
			if (nx >= N || map[nx][y] == 6) return;
			map[nx][y] = -1;
			spread(dir, nx, y);

		}
		if(dir == 3) {
			int ny = y + 1;
			if (ny >= M || map[x][ny] == 6) return;
			map[x][ny] = -1;
			spread(dir, x, ny);
		}
	}

	private static int count() {
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					num++;
			}
		}
		return num;
	}
}

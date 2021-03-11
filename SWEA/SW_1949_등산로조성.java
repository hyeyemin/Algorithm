import java.util.Scanner;

public class SW_1949_등산로조성 {
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int[][] map;
	static boolean slice;
	static boolean[][] visited;
	static int N, K, count, lengthMax;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			lengthMax = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(map[i][j], max);
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						check(i, j, 1, true);
					}
				}
			}
			System.out.println("#" + t + " " + lengthMax);
		}
	}
	private static void check(int i, int j, int count, boolean slice) {
		lengthMax = Math.max(count, lengthMax);
		
		for(int k = 0; k < 4; k++) {
			int nx = dx[k] + i;
			int ny = dy[k] + j;
			if(nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny]) continue;
			if(map[i][j] > map[nx][ny]) {
				visited[i][j] = true;
				check(nx, ny, count+1, slice);
				visited[i][j] = false;				
			}else if(slice && map[nx][ny] - map[i][j] < K && map[i][j] != 0) {
				slice = false;
				int temp = map[nx][ny];
				map[nx][ny] = map[i][j]-1;
				visited[i][j] = true;
				check(nx, ny, count+1, slice);
				visited[i][j] = false;
				map[nx][ny] = temp;
				slice = true;
			}
			else continue;
		}
		
	}
}

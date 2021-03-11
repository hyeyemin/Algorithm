package line;

public class Test04 {
	public static void main(String[] args) {
//		int[][] maze = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
//		int[][] maze = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
//		int[][] maze = {{0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}};
		int[][] maze = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}};
		System.out.println(solution(maze));
	}
	private static int solution(int[][] maze) {
		int i = 0, j = 0, result = 0;
		boolean visited[][] = new boolean[maze.length][maze.length];
		//오른, 위, 왼, 아래
		int dx[] = {0, -1, 0, 1};
		int dy[] = {1, 0, -1, 0};
		int dir = 0;
		while(i != maze.length-1 || j != maze.length-1) {
			result++;
			//왼손에 벽이 있나 체크
			int cx = dx[dir] + i;
			int cy = dy[dir] + j;
			//벽이 있는 경우
			if(cx < 0 || cx >= maze.length || cy < 0 || cy >= maze.length || maze[cx][cy] == 1) {
				//전진할 방향 = 왼손방향-1
				int nx = 0, ny = 0, ndir = 0;
				if(dir == 0) {
					ndir = 3;
				}else {
					ndir = dir-1;
				}
				nx = dx[ndir] + i;
				ny = dy[ndir] + j;
				//전진할 방향이 막힌 경우 방향 전환
				while(nx < 0 || nx >= maze.length || ny < 0 || ny >= maze.length || maze[nx][ny] == 1) {
					if(ndir == 0) {
						ndir = 3;		
					}else {
						ndir--;
					}
					nx = dx[ndir] + i;
					ny = dy[ndir] + j;	
					if(ndir == 3) dir = 0;
					else dir = ndir+1;
				}
				i = nx;
				j = ny;
			}
			//없는 경우 방향 바꾸고 그대로 감!
			else {
				if(dir == 3) dir = 0;
				else dir++;
				i = cx;
				j = cy;
			}
		}
		return result;
	}
}

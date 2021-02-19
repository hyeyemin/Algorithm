package com.ssafy.day13;

import java.util.Scanner;

public class JO_1733_오목 {
	static int[] dx = {0, 1, -1, 1}; //오른쪽, 아래, 대각선위, 대각선 아래
	static int[] dy = {1, 0, 1, 1};
	static int[] checkDx = {0, -1, 1, -1};
	static int[] checkDy = {-1, 0, -1, -1};
	static boolean visited[][] = new boolean[19][19];
	static int count = 1;
	static int[][] board = new int[19][19];
	static boolean five;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[i][j] == 0) continue;
				if(board[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						count = 1;
						check(i, j, 1, k);
						if(count == 5) {
							int nx = i + checkDx[k];
							int ny = j + checkDy[k];
							if(nx < 0 || ny < 0 || nx >= 19 || ny >= 19) {
								System.out.println(1);
								System.out.println((i+1) + " " + (j+1));
								System.exit(0);
							}
							if(board[nx][ny] == 1) break;
							else {
								System.out.println(1);
								System.out.println((i+1) + " " + (j+1));
								System.exit(0);
							}
						}
					}
				}
				if(board[i][j] == 2) {
					for(int k = 0; k < 4; k++) {
						count = 1;
						check(i, j, 2, k);
						if(count == 5) {
							int nx = i + checkDx[k];
							int ny = j + checkDy[k];
							if(nx < 0 || ny < 0 || nx >= 19 || ny >= 19) {
								System.out.println(2);
								System.out.println((i+1) + " " + (j+1));
								System.exit(0);
							}
							if(board[nx][ny] == 2) break;
							else {
								System.out.println(2);
								System.out.println((i+1) + " " + (j+1));
								System.exit(0);
							}
						}
					}
				}
			}
			
		}
		System.out.println(0);
	}
	
	private static void check(int i, int j, int color, int dir) {
		int nx = i + dx[dir];
		int ny = j + dy[dir];
		if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) return;
		if(visited[nx][ny]) return;
		if(board[nx][ny] == color) {
			count++;
			visited[i][j] = true;
			check(nx, ny, color, dir);
			visited[i][j] = false;
		}
	}
}

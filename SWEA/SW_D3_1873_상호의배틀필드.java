package com.ssafy.day03;

import java.util.Scanner;

public class SW_D3_1873_상호의배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[H][W];
			for(int i = 0; i < H; i++) {
				String s = sc.nextLine();
				map[i] = s.toCharArray();
			}
			int N = sc.nextInt();
			sc.nextLine();
			char[] input = sc.nextLine().toCharArray();
			int currX = 0;
			int currY = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == '>' || map[i][j] == '^' || map[i][j] == '<' || map[i][j] == 'v') {
						currX = i;
						currY = j;
					}
				}
			}
			for(int i = 0; i < N; i++) {
				if(input[i] == 'U') {
					if(currX-1 >= 0 && map[currX-1][currY] == '.') {
						map[currX][currY] = '.';
						currX--;
					}
					map[currX][currY] = '^';
				}
				if(input[i] == 'D') {
					if(currX+1 < H && map[currX+1][currY] == '.') {
						map[currX][currY] = '.';
						currX++;
					}
					map[currX][currY] = 'v';
				}
				if(input[i] == 'R') {
					if(currY+1 < W && map[currX][currY+1] == '.') {
						map[currX][currY] = '.';
						currY++;
					}
					map[currX][currY] = '>';
				}
				if(input[i] == 'L') {
					if(currY-1 >= 0 && map[currX][currY-1] == '.') {
						map[currX][currY] = '.';
						currY--;
					}
					map[currX][currY] = '<';
				}
				if(input[i] == 'S') {
					if(map[currX][currY] == '^') {
						for(int k = currX-1; k >= 0; k--) {
							if(map[k][currY] == '#') break;
							if(map[k][currY] == '*') {
								map[k][currY] = '.';
								break;
							}
							if(map[k][currY] == '-' || map[k][currY] == '.') continue;
						}
					}
					if(map[currX][currY] == 'v') {
						for(int k = currX+1; k < H; k++) {
							if(map[k][currY] == '#') break;
							if(map[k][currY] == '*') {
								map[k][currY] = '.';
								break;
							}
							if(map[k][currY] == '-' || map[k][currY] == '.') continue;
						}
					}
					if(map[currX][currY] == '<') {
						for(int k = currY-1; k >= 0; k--) {
							if(map[currX][k] == '#') break;
							if(map[currX][k] == '*') {
								map[currX][k] = '.';
								break;
							}
							if(map[currX][k] == '-' || map[currX][k] == '.') continue;
						}
					}
					if(map[currX][currY] == '>') {
						for(int k = currY+1; k < W; k++) {
							if(map[currX][k] == '#') break;
							if(map[currX][k] == '*') {
								map[currX][k] = '.';
								break;
							}
							if(map[currX][k] == '-' || map[currX][k] == '.') continue;
						}
					}
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println("");
			}
		}
	}
}

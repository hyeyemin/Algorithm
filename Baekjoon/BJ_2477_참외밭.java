package com.ssafy.day13;

import java.util.Scanner;

public class BJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[][] map = new int[6][2];
		int n = 0;
		for(int i = 0; i < 6; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}
		
		int maxX = 0; int maxY = 0; int indexA = 0; int indexB = 0;
		for(int i = 0; i < 6; i++) {
			if(map[i][0] == 1 || map[i][0] == 2) {
				if(maxX <= map[i][1]) {
					maxX = Math.max(map[i][1], maxX);
					indexA = i;
				}
			}
			if(map[i][0] == 3 || map[i][0] == 4) {
				if(maxY <= map[i][1]) {
					maxY = Math.max(map[i][1], maxY);
					indexB = i;
				}
			}
		}
		int smallW = 0, smallH = 0;
		if(indexA == 0) smallW = Math.abs(map[5][1] - map[1][1]);
		else if(indexA == 5) smallW = Math.abs(map[4][1] - map[0][1]);
		else smallW = Math.abs(map[indexA-1][1] - map[indexA+1][1]);
		
		if(indexB == 0) smallH = Math.abs(map[5][1] - map[1][1]);
		else if(indexB == 5) smallH = Math.abs(map[4][1] - map[0][1]);
		else smallH = Math.abs(map[indexB-1][1] - map[indexB+1][1]);
		
		
		System.out.println((maxX * maxY - smallW * smallH) * k); 
	}
}

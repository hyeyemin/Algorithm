package com.ssafy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5644_무선충전 {
	static int M, bcCnt;
	static int[] pathA, pathB, playerA, playerB;
	static int[][] bc;
	
	static int dx[] = {0,0,1,0,-1};
	static int dy[] = {0,-1,0,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		playerA = new int[2];
		playerB = new int[2];
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			bcCnt = Integer.parseInt(st.nextToken());
			
			playerA[0] = playerA[1] = 1;
			playerB[0] = playerB[1] = 10;
			
			pathA = new int[M+1];
			pathB = new int[M+1];
			bc = new int[bcCnt][4];
			
			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= M; i++) {
				pathA[i] = Integer.parseInt(stA.nextToken());
				pathB[i] = Integer.parseInt(stB.nextToken());
			}
			
			for(int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i][0] = Integer.parseInt(st.nextToken()); //x
				bc[i][1] = Integer.parseInt(st.nextToken()); //y
				bc[i][2] = Integer.parseInt(st.nextToken()); //거리
				bc[i][3] = Integer.parseInt(st.nextToken()); //충전량
			}
			
			System.out.println("#" + t + " " + move());
		}
	}

	private static int move() {
		int totalSum = 0;
		//매시간마다의 각 위치에서 두 플레이어의 최대 충전량을 계산하여 합산
		for(int t = 0; t <= M; t++) {
			// 두 플레이어 궤적에 따라 이동
			playerA[0] += dx[pathA[t]];
			playerA[1] += dy[pathA[t]];
			playerB[0] += dx[pathB[t]];
			playerB[1] += dy[pathB[t]];
			
			//현 위치에서의 최대충전량 계싼
			totalSum += getMaxCharge();
		}
		return totalSum;
	}
	private static int check(int a, int x, int y) {
		return Math.abs(bc[a][0]-x) + Math.abs(bc[a][1]-y) <= bc[a][2] ? bc[a][3] : 0;
	}
	private static int getMaxCharge() {
		int max = 0;
		for(int a = 0; a < bcCnt; a++) { //플레이어 A가 선택한 BC
			for(int b = 0; b < bcCnt; b++) { //플레이어 B가 선택한 BC
				int sum = 0;
				int amountA = check(a, playerA[0], playerA[1]);
				int amountB = check(b, playerB[0], playerB[1]);
				
				//두 충전소가 다르면
				if(a != b) sum = amountA + amountB;
				else sum = Math.max(amountA, amountB);
				
				max = Math.max(sum, max);
			}
		}
		return max;
	}
}

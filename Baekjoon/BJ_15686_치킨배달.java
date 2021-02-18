package com.ssafy.day11;

import java.util.Scanner;

public class BJ_15686_치킨배달 {
	static class Location{
		int x,y;
		Location(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int n,m, chiCount, homeCount, min = 99999;
	static Location[] chiken, mChiken, home;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		chiken = new Location[13];
		mChiken = new Location[m];
		home = new Location[2*n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				if(temp == 2) {
					chiken[chiCount++] = new Location(i,j);
				}
				if(temp == 1) {
					home[homeCount++] = new Location(i,j);
				}
			}
		}
		combi(0,0);
		System.out.println(min);
		
	}
	private static void combi(int cnt, int start) {
		if(cnt == m) {
			double result = 0;
			for(int i = 0; i < homeCount; i++) {
				Location temp = home[i];
				double homeResult = Math.abs(temp.x - mChiken[0].x) + Math.abs(temp.y - mChiken[0].y);
				for(int j = 1; j < m; j++) {
					double temp2 = Math.abs(temp.x - mChiken[j].x) + Math.abs(temp.y - mChiken[j].y);
					if(temp2 <= homeResult) {
						homeResult = temp2;
					}
				}
				result += homeResult;
			}
			if(result <= min) {
				min = (int)result;
			}
			return;
		}
		for(int i = start; i < chiCount; i++) {
			mChiken[cnt] = chiken[i];
			combi(cnt+1, i+1);
		}
	}
	
}

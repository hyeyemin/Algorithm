package com.ssafy.day11;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_17135_캐슬디펜스 {
	static class Loc {
		int x,y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int n, m, d, max, count;
	static int[] newArr = new int[3];
	static ArrayList<Loc> list, original;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		original = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(sc.nextInt() == 1) {
					original.add(new Loc(i,j));
				}
			}
		}
		combi(0,0);
		System.out.println(max);
	}
	private static void combi(int cnt, int start) {
		if(cnt == 3) {
			list = new ArrayList<>();
			for(int i = 0; i < original.size(); i++) {
				list.add(original.get(i));
			}
			count = 0;
			game();
			max = Math.max(count, max);
			return;
		}
		for(int i = start; i < m; i++) {
			newArr[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	private static void game() {
		for(int t = 0; t < n; t++) {
			ArrayList<Loc> dead = new ArrayList<>();
			for(int k = 0; k < 3; k++) {
				int min = Integer.MAX_VALUE;
				Loc[] minEnemies = new Loc[list.size()];
				int[] minEnemies2 = new int[list.size()];
				int num = 0;
				Loc enemy = new Loc(-1,-1);
				for(int i = 0; i < list.size(); i++) {
					int temp = n - list.get(i).x + Math.abs(list.get(i).y - newArr[k]);
					if(temp <= d && min >= temp) {
						minEnemies[num] = list.get(i);
						minEnemies2[num++] = temp;
						min = Math.min(temp, min);
					}
				}
				int left = m;
				for(int i = 0; i < minEnemies.length; i++) {
					if(minEnemies[i] != null && minEnemies2[i] == min && minEnemies[i].y <= left) {
						left = Math.min(minEnemies[i].y, left);
						enemy = minEnemies[i];
					}
				}
				if(min != Integer.MAX_VALUE) dead.add(enemy);
			}
			for(int i = 0; i < dead.size(); i++) {
				if(list.remove(dead.get(i))) count++;
			}
			for(int i = 0; i < list.size(); i++) {
				Loc temp = list.get(i);
				list.remove(temp);
				if(temp.x+1 < n) list.add(i, new Loc(temp.x+1, temp.y));
			}
		}
	}
}

package com.ssafy.day09;

import java.util.ArrayList;
import java.util.Scanner;

public class SW_6808_D3_규영이와인영이의카드게임 {
	static ArrayList<Integer> user, com;
	static boolean isSelected[] = new boolean[9];
	static int[] arr;
	static int win, lose;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			user = new ArrayList<>();
			com = new ArrayList<>();
			for(int i = 0; i < 9; i++) {
				user.add(sc.nextInt());
			}
			for(int i = 1; i <= 18; i++) {
				if(!user.contains(i)) com.add(i);
			}
			win = 0;
			lose = 0;
			arr = new int[9];
			perm(0);
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}
	private static void perm(int cnt) {
		if(cnt == 9) {
			game();
			return;
		}
		for(int i = 0; i < com.size(); i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			arr[cnt] = com.get(i);
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	private static void game() {
		int userTotal = 0;
		int comTotal = 0;
		for(int i = 0; i < 9; i++) {
			if(arr[i] > user.get(i)) {
				comTotal += arr[i] + user.get(i);
			}else {
				userTotal += arr[i] + user.get(i);
			}
		}
		if(userTotal > comTotal) win++;
		else if (comTotal > userTotal) lose++;
	}
}

package com.ssafy.day08;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SW_1974_D2_스도쿠검증 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int[][] area = new int[10][10];
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			int result = 1;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					for(int k = 0; k < 9; k++) {
						if(j!=k && area[i][j] == area[i][k]) result = 0;
						if(j!=k && area[j][i] == area[k][i]) result = 0;
					}
				}
			}
			for(int i = 0; i < 6; i+=3) {
				for(int j = 0; j < 6; j+=3) {
					int[] arr = new int[9];
					int num = 0;
					for(int k = 0; k < 3; k++) {
						for(int l = 0; l < 3; l++) {
							arr[num++] = area[i+k][j+l];
						}
					}
					Arrays.sort(arr);
					String s = "";
					for(int k : arr) {
						s += k;
					}
					String temp = "123456789";
					if(!temp.equals(s)) result = 0;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}

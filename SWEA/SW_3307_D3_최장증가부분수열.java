package com.ssafy.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3307_D3_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int[] D = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			D[0] = 1;
			for(int i = 1; i < N; i++) {
				D[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && D[j] + 1 > D[i]) {
						D[i] = D[j] + 1;
					}
				}
				max = Math.max(D[i], max);
			}
			System.out.println("#" + t + " " + max);
		}
	}
}

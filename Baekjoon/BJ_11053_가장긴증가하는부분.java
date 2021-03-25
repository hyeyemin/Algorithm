package com.ssafy.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11053_가장긴증가하는부분 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] D = new int[N];
		D[0] = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 1;
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
		System.out.println(max);
	}
}

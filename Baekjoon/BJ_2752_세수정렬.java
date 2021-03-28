package com.ssafy.day22;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2752_세수정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] arr = new long[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		for(long l : arr) {
			System.out.print(l + " ");
		}
	}
}

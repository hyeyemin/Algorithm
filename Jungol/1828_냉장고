package com.ssafy.homework18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JO_1828_냉장고 {
	static class Matter implements Comparable<Matter>{
		int min;
		int max;
		Matter(int min, int max){
			this.min = min;
			this.max = max;
		}
		@Override
		public int compareTo(Matter o) {
			// TODO Auto-generated method stub
			return this.max - o.max;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Matter[] arr = new Matter[N]; 
		for(int i = 0; i < N; i++) {
			arr[i] = new Matter(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
		Matter m = arr[0];
		int count = 1;
		for(int i = 1; i < N; i++) {
			if(arr[i].min > m.max) {
				m = arr[i];
				count++;
			}
		}
		System.out.println(count);
	}
}

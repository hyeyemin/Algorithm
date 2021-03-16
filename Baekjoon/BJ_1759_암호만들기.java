package com.ssafy.day15;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1759_암호만들기 {
	private static int L, C;
	private static char[] arr, newArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		String[] s = sc.nextLine().split(" ");
		arr = new char[C];
		for(int i = 0; i < C; i++) {
			arr[i] = s[i].charAt(0);
		}
		newArr = new char[L];
		Arrays.sort(arr);
		combi(0,0);
	}
	private static void combi(int start, int cnt) {
		if(cnt == L) {
			String temp = "";
			for(char c: newArr) {
				temp += c;
			}
			if(check(temp)) System.out.println(temp); 
			return;
		}
		for(int i = start; i < C; i++) {
			newArr[cnt] = arr[i];
			combi(i+1, cnt+1);
		}
	}
	private static boolean check(String temp) {
		int count = 0;
		for(int i = 0; i < temp.length(); i++) {
			if(temp.charAt(i) == 'a' || temp.charAt(i) == 'e' ||temp.charAt(i) == 'i' 
					|| temp.charAt(i) == 'o' || temp.charAt(i) == 'u' ) {
				count++;
			}
		}
		if(count < 1 || count > L-2) return false;
		else return true;
	}
}

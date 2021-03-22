package com.ssafy.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1786_찾기 {
	static char[] pattern;
	static int[] pArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		pattern = br.readLine().toCharArray();
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 0;
		int j = 0;
		fail();
		for(int i = 0; i < text.length; i++) {
			while(j > 0 && text[i] != pattern[j]) {
				j = pArr[j-1];
			}
			if(text[i] == pattern[j]) {
				if(j == pattern.length-1) {
					cnt++;
					list.add(i-j+1);
					j = pArr[j];
				}else
					j++;
			}
		}
		System.out.println(cnt);
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
	private static void fail() {
		pArr = new int[pattern.length];
		int j = 0;
		for(int i = 1; i < pattern.length; i++) {
			while(j > 0 && pattern[i] != pattern[j])
				j = pArr[j-1];
			if(pattern[i] == pattern[j])
				pArr[i] = ++j;
		}
		
	}
}

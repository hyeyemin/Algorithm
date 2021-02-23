package com.ssafy.day13;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SW_10912_D3_외로운문자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 1; t <= T; t++) {
			char[] array = sc.nextLine().toCharArray();
			for(int i = 0 ; i < array.length; i++) {
				for(int j = i+1; j < array.length; j++) {
					if(array[i] == array[j]) {
						array[i] = '0';
						array[j] = '0';
					}
				}
			}
			Arrays.sort(array);
			System.out.print("#" + t + " ");
			int count = 0;
			for(int i = 0; i < array.length; i++) {
				if(array[i] != '0') {
					System.out.print(array[i]);
					count++;
				}
			}
			if(count == 0) System.out.print("Good");
			System.out.println();
		}
	}
}

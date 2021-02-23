package com.ssafy.day13;

import java.util.Scanner;
import java.util.Stack;

public class SW_10804_D3_문자열의거울상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 1; t <= T; t++) {
			String s = sc.nextLine();
			Stack<Character> stack = new Stack();
			for(int i = 0; i < s.length(); i++) {
				stack.push(s.charAt(i));
			}
			System.out.print("#" + t + " ");
			while(!stack.isEmpty()) {
				char temp = stack.pop();
				switch(temp){
				case 'p': 
					System.out.print('q');
					break;
				case 'q':
					System.out.print('p');
					break;
				case 'b':
					System.out.print('d');
					break;
				case 'd':
					System.out.print('b');
				}
			}
			System.out.println();
		}
	}
}

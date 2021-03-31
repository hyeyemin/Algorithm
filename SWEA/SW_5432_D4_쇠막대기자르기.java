package com.ssafy.day05;

import java.util.Scanner;
import java.util.Stack;

public class SW_5432_D4_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 1; t <= T; t++) {
			String s = sc.nextLine();
			char[] arr = s.toCharArray();
			Stack<Character> stack = new Stack<>();
			int result = 0;
			stack.push('(');
			for(int i = 1; i < arr.length; i++) {
				if(!stack.isEmpty()) {
					if(arr[i] == ')' && arr[i-1] == '(') {
						stack.pop();
						result += stack.size();
					}else if(arr[i] == '('){
						stack.push(arr[i]);
					}else{
						result++;
						stack.pop();
					}
				}else stack.push(arr[i]);
			}
			System.out.println("#" + t + " " + result);
		}
	}
}

package com.ssafy.day05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_3499_D3_퍼팩트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			sc.nextLine();
			String s = sc.nextLine();
			for(int i = 0; i < N; i++) {
				if(N % 2 == 0) {
					if(i < N/2) q1.add(s.split(" ")[i]);
					else q2.add(s.split(" ")[i]);
				}else {
					if(i <= N/2) q1.add(s.split(" ")[i]);
					else q2.add(s.split(" ")[i]);
				}
			}
			System.out.print("#" + t);
			for(int i = 0; i < N; i++) {
				if(i % 2 == 0) {
					System.out.print(" " + q1.poll());
				}else {
					System.out.print(" " + q2.poll());
				}
			}
			System.out.println("");
		}
	}
}

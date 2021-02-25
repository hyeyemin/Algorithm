package com.ssafy.day14;

import java.util.Scanner;

public class BJ_2527_직사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 4; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int X1 = sc.nextInt();
			int Y1 = sc.nextInt();
			int X2 = sc.nextInt();
			int Y2 = sc.nextInt();
			char code = 'a';
			if ((x2 == X1 && y2 == Y1) || (x1 == X2 && y2 == Y1) || (x2 == X1 && y1 == Y2) || (x1 == X2 && y1 == Y2)) {
	            code = 'c';
	        } else if ((x2 == X1 && y2 != Y1) || (x1 == X2 && y2 != Y1) || (x2 != X1 && y1 == Y2) || (x1 != X2 && y1 == Y2)) {
	        	code = 'b';
	        } else if (x2 < X1 || X2 < x1 || y2 < Y1 || Y2 < y1) {
	        	code = 'd';
	        } else {
	            code ='a';
	        }
			System.out.println(code);
		}
	}
}

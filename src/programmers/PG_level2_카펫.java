package com.ssafy.day14;

import java.util.Scanner;

public class PG_level2_카펫 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int brown = sc.nextInt();
		 int yellow = sc.nextInt();
		 System.out.println(solution(brown, yellow)[0] + " " + solution(brown, yellow)[1]);
	}
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int temp = brown/2+2;
        int deter = temp * temp - (4*total);
        int root = (int)Math.sqrt(deter);
        int m = (temp * (-1) + root) / 2;
        int n = (temp * (-1) - root) / 2;
        answer[0] = Math.abs(n);
        answer[1] = Math.abs(m);
        return answer;
    }
}

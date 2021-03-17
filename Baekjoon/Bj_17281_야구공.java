package com.ssafy.day16;

import java.util.Arrays;
import java.util.Scanner;

public class Bj_17281_야구공 {
	static int N, max;
	static int[][] area;
	static boolean[] visited = new boolean[9];
	static int[] order = new int[8];
	static boolean[] ru = new boolean[4]; // 1루 2루 3루 홈

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 1:안타 2:2루타 3루타 4홈런 0아웃
		area = new int[N][9];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				area[i][j] = sc.nextInt();
			}
		}
		perm(0);
		System.out.println(max);
	}

	private static void perm(int cnt) {
		if (cnt == 8) {
			max = Math.max(max, game());
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (visited[i])
				continue;
			order[cnt] = i;
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static int game() {
		ru = new boolean[3];
		int last = 0;
		int totalScore = 0;
		// N이닝동안 진행
		// 한 이닝에 3아웃 발생하면 이닝 종료
		for (int i = 0; i < N; i++) {
			int out = 0;
			int score = 0;
			ru = new boolean[3];
			while (true) {
				if (out >= 3)
					break;
				int count = 0;
				for (int j = last; count < 9; j++) {
					j = j % 9;
					count++;
					int ta = 0;
					if (j < 3) {
						ta = area[i][order[j]];
					}
					if (j == 3) {
						ta = area[i][0];
					}
					if (j > 3) {
						ta = area[i][order[j - 1]];
					}
					if (ta == 0) {
						out++;
						if (out >= 3) {
							last = j % 9 + 1;
							break;
						}
					}
					score += move(ta);
				}
			}
			totalScore += score;
		}
		return totalScore;
	}

	private static int move(int count) {
		int increase = 0;
		boolean newRu[] = new boolean[3];
		if (count == 0) return 0;
		for (int i = 0; i < ru.length; i++) {
			if (ru[i]) {
				int next = i + count;
				if (next >= ru.length) {
					increase++;
					continue;
				} else {
					newRu[next] = ru[i];
					ru[i] = false;
				}
			}
		}
		ru = Arrays.copyOf(newRu, 3);
		if(count == 4) {
			increase++;
		}else{
			ru[count-1] = true;
		}
		return increase;
	}
}

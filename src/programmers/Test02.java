package kakao;

import java.util.Arrays;

public class Test02 {
	static int[] robots;
	static String[] complete;
	static int answer;
	public static void main(String[] args) {
//		int[][] needs = {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, { 0, 1, 1}};
		int[][] needs = {{ 1, 1, 1 }, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, { 1, 1, 1}};
		System.out.println(solution(needs, 3));
	}
	public static int solution(int[][] needs, int r) {
		robots = new int[r];
        complete = new String[needs.length];
        Arrays.fill(complete, "");
        for(int i = 0; i < needs.length; i++) {
        	for(int j = 0; j < needs[i].length; j++) {
        		if(needs[i][j] == 1) {
        			complete[i] +=  j;
        		}
        	}
        }
        combi(0, 0, needs[0].length, r);
        return answer;
    }
	private static void combi(int start, int cnt, int length, int r) {
		if(cnt == r) {
			String temp = "";
			for(int i : robots) {
				temp += i;
			}
			int num = 0;
			for(int i = 0; i < complete.length; i++) {
				if(temp.contains(complete[i])) num++; 
			}
			answer = Math.max(num, answer);
			return;
		}
		for(int i = start; i < length; i++) {
			robots[cnt] = i;
			combi(i+1, cnt+1, length, r);
		}
	}
}

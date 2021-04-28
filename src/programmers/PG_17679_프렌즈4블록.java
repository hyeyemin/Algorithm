package week05;

import java.util.Stack;

public class PG_17679_프렌즈4블록 {
	static char[][] board;
	static boolean[][] isPop;
	static int count;
	public static void main(String[] args) {
//		String[] b = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] b = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
//		String[] b = {"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"};
		System.out.println(solution(6,6,b));
	}
	private static int solution(int m, int n, String[] b) {
		board = new char[m][n];
		isPop = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = b[i].charAt(j);
			}
		}
		pop(m,n);
		return count;
	}
	private static void pop(int m, int n) {
		while(isAvailable(m,n)) {
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(isPop[i][j]) {
						board[i][j] = ' ';
						count++;
					}
				}
			}
			isPop = new boolean[m][n];
			makeBoard(m,n);
		}
	}
	private static boolean isAvailable(int m, int n) {
		boolean poped = false;
		for(int i = 0; i < m-1; i++) {
			for(int j = 0; j < n-1; j++) {
				if(check(i,j)) {
					isPop[i][j] = true;
					isPop[i+1][j] = true;
					isPop[i][j+1] = true;
					isPop[i+1][j+1] = true;
					poped = true;
				}
			}
		}
		return poped;
	}
	private static boolean check(int x, int y) {
		char cur, pre = '.';
		for(int i = x; i < x+2; i++) {
			for(int j = y; j < y+2; j++) {
				cur = board[i][j];
				if((pre != '.' && pre != cur) || cur == ' ') return false;
				pre = cur;
			}
		}
		if(pre == '.') return false;
		return true;
	}
	private static void makeBoard(int m, int n) {
		Stack<Character> stack = new Stack<>();
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < m; i++) {
				if(board[i][j] != ' ') stack.push(board[i][j]);
			}
			for(int i = m-1; i >= 0; i--) {
				if(stack.isEmpty()) board[i][j] = ' ';
				else board[i][j] = stack.pop();
			}
		}
	}
}

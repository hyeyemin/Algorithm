package programmers;

import java.util.*;

public class Stack_prices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = { 1, 2, 3, 2, 3 };
		for (int i = 0; i < p.length; i++) {
			System.out.print(solution(p)[i] + " ");
		}
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for(int i=0; i<prices.length; i++) {
			int count = 0;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i]<=prices[j]) {
					count++;
				}else {
					if(i!=prices.length-1) {
						count++;
					}
					break;
				}
			}
			answer[i] = count;
		}
		return answer;
	}
}

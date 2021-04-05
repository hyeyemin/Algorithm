package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test01 {
	public static void main(String[] args) {
		int[] gift_cards = new int[100000];
		int[] wants = new int[100000];
		Arrays.fill(gift_cards, 1);
		Arrays.fill(wants, 2);
		System.out.println(solution(gift_cards, wants));
	}
	 public static int solution(int[] gift_cards, int[] wants) {
	     int answer = gift_cards.length;
	     Queue<Integer> q = new LinkedList<>();
	     for(int i = 0; i < wants.length; i++) {
	    	 q.offer(wants[i]);
	     }
	     for(int i = 0; i < gift_cards.length; i++) {
	    	 int cnt = 0;
	    	while(!q.isEmpty() && cnt != wants.length) {
	    		cnt++;
	    		int temp = q.poll();
	    		if(temp == gift_cards[i]) {
	    			answer--;
	    			break;
	    		}
	    		else q.add(temp);
	    	}
	     }
	     return answer;
	 }
}

package line;

import java.util.ArrayList;

public class Test05 {
	static ArrayList<Integer> player;
	static ArrayList<Integer> dealer;
	
	public static void main(String[] args) {
//		int[] cards = {12, 7, 11, 6, 2, 12};
//		int[] cards = {1, 4, 10, 6, 9, 1, 8, 13};
//		int[] cards = {10, 13, 10, 1, 2, 3, 4, 5, 6, 2};
		int[] cards = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		System.out.println(solution(cards));
	}
	private static int solution(int[] cards) {
		//더 이상 카드 뽑을 거 없을때 어떻게 깔끔하게 끝내나요...
		int result = 0;
		for(int i = 0; i < cards.length;) {
			player = new ArrayList<>();
			dealer = new ArrayList<>();
			player.add(select(cards[i++], player));
			if(i == cards.length) break;
			dealer.add(select(cards[i++], dealer));
			if(i == cards.length) break;
			player.add(select(cards[i++], player));
			if(i == cards.length) break;
			
			//딜러가 보여줄 카드
			int show = cards[i++];
			if(i == cards.length) break;
			//보여주고나서 1로 쓸지 11로 쓸지 결정
			dealer.add(select(show, dealer));
			
			if(sum(player) == 21) {
				if(sum(dealer) != 21) {
					result += 3;
					continue;
				}
				else {
					result -= 2;
					continue;
				}
			}else {
				if(show == 1 || show >=7) {
					while(sum(player) < 17) {
						player.add(select(cards[i++], player));
						if(i == cards.length) break;
					}
				}
				if(show == 2 || show == 3) {
					while(sum(player) < 12) {
						player.add(select(cards[i++], player));
						if(i == cards.length) break;
					}
				}
				while(sum(dealer) < 17) {
					dealer.add(select(cards[i++], dealer));
					if(i == cards.length) break;
				}
				if(sum(dealer) > 21) {
					result += 2;
					continue;
				}
				if(21-sum(player) < 21-sum(dealer)) {
					result += 2;
					continue;
				}
				else {
					result -= 2;
				}	
			}
		}
		return result;
	}
	//11이상인 카드 10으로 만들어주기, 1일 때 1로 할지 11로 할지 결정
	private static int select(int num, ArrayList<Integer> list) {
		if(num >= 11) num = 10;
		if(num == 1) {
			if(sum(list) + 11 < 21) return 11;
			else return 1;
		}
		return num;
	}
	private static int sum(ArrayList<Integer> list) {
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i);
		}
		return result;
	}
}

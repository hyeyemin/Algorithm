package line;

import java.util.ArrayList;
import java.util.Collections;

public class Test01 {
	public static void main(String[] args) {
		int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
//		int[][] boxes = {{1, 2}, {3, 4}, {5, 6}};
//		int[][] boxes = {{1, 2}, {2, 3}, {3, 1}};
		System.out.println(solution(boxes));
	}
	private static int solution(int[][] boxes) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < boxes.length; i++) {
			list.add(boxes[i][0]);
			list.add(boxes[i][1]);
		}
		//박스에 있던 모든 아이템을 하나의 list에 넣고 정렬
		Collections.sort(list);
		//같은 아이템끼리 묶고 남은 상품 추가구매
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i) == list.get(i+1)) {
				list.remove(i);
				list.remove(i);
				i--;
			}
		}
		return list.size()/2;
	}
}

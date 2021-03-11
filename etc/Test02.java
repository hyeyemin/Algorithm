package line;

import java.util.ArrayList;
import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
//		int[] ball = {1, 2, 3, 4, 5, 6};
		int[] ball = {11, 2, 9, 13, 24};
//		int[] order = {6, 2, 5, 1, 4, 3};
		int[] order = {9, 2, 13, 24, 11};
		System.out.println(Arrays.toString(solution(ball, order)));
	}
	private static int[] solution(int[] ball, int[] order) {
		int[] result = new int[ball.length];
		int index = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < ball.length; i++) {
			list.add(ball[i]);
		}
		ArrayList<Integer> wait = new ArrayList<>();
		//order만큼 반복
		for(int i = 0; i < order.length; i++) {
			//order의 수가 양쪽 끝에 있는 경우 result에 넣고 삭제
			if(order[i] == list.get(0) || order[i] == list.get(list.size()-1)) {
				result[index++] = order[i];
				list.remove((Object)order[i]);
			}else wait.add(order[i]); //아니라면 wait에 넣어줌
			
			//wait중에서 양쪽 끝에 있는 경우 result에 넣고 삭제
			while(!list.isEmpty() && wait.contains(list.get(0))) {
				result[index++] = list.get(0);
				wait.remove((Object)list.get(0));
				list.remove(0);
			}
			while(!list.isEmpty() && wait.contains(list.get(list.size()-1))) {
				result[index++] = list.get(list.size()-1);
				wait.remove((Object)list.get(list.size()-1));
				list.remove(list.size()-1);
			}
		}
		return result;
	}
}

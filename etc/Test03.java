package line;

import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(9)));
	}
	private static int[] solution(int n) {
		int[] result = new int[2];
		String sn = String.valueOf(n);
		int count = 0;
		//적게 만드는 방법은 반으로 나눈 다음 더하기
		while(sn.length() != 1) {
			int start = sn.length()/2;
			//반으로 나눴을 때 0으로 시작하면 0으로 시작하지 않는 수를 찾아줌
			while(sn.charAt(start) == '0') {
				if(start == sn.length()-1) break;
				start++;
			}
			String sn1 = sn.substring(0, start);
			String sn2 = sn.substring(start, sn.length());
			sn = String.valueOf(Integer.parseInt(sn1) + Integer.parseInt(sn2));
			count++;
		}
		result[0] = count;
		result[1] = Integer.parseInt(sn);
		return result;
	}
}

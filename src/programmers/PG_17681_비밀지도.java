package week06;

import java.util.Arrays;

public class PG_17681_비밀지도 {
	public static void main(String[] args) {
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution(5,arr1,arr2)));
	}
	private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
        	answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        	answer[i] = String.format("%"+n+"s", answer[i]);
        	answer[i] = answer[i].replace('1', '#');
        	answer[i] = answer[i].replace("0", " ");
        }        
        return answer;
    }
}

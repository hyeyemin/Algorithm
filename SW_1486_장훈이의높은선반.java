import java.util.Scanner;

public class SW_1486_장훈이의높은선반 {
	static int N, B, min=Integer.MAX_VALUE;
	static int[] people, newArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();
			people = new int[N];
			for(int i = 0; i < N; i++) {
				people[i] = sc.nextInt();
			}
			min=Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++) {
				newArr = new int[i];
				combi(0, 0, i);
			}
			System.out.println("#" + t + " " + min);
		}
	}
	
	private static void combi(int start, int cnt, int k) {
		if(cnt == k) {
			int total = 0;
			for(int i : newArr) {
				total += i;
			}
			if(total >= B) {
				min = Math.min(total-B, min);
			}
			return;
		}
		for(int i = start; i < N; i++) {
			newArr[cnt] = people[i];
			combi(i+1, cnt+1, k);
		}
	}
}

package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4256_트리 {
	static int[] pre;
	static int[] in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			pre = new int[N];
			in = new int[N];
			for(int n = 0; n < N; n++) {
				pre[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				in[n] = Integer.parseInt(st.nextToken());
			}
			post(0, 0, N);
			System.out.println();
		}
	}
	private static void post(int root, int start, int end) {
		for(int i = start; i < end; i++) {
			if(in[i] == pre[root]) {
				//왼쪽 서브트리
				post(root + 1, start, i);
				//오른쪽 서브트리 -> 루트 : 왼쪽 크기 + 1
				post(root + i + 1 - start, i+1, end);
				System.out.print(pre[root] + " ");
			}
		}
	}
}

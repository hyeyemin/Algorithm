package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_5052_전화번호목록 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] temp = new String[n];
			for(int i = 0; i < n; i++) {
				temp[i] = br.readLine();
			}
			Arrays.sort(temp);
			String result = "YES";
			for(int i = 0; i < n-1; i++) {
				if(temp[i+1].length() > temp[i].length() && temp[i+1].substring(0, temp[i].length()).equals(temp[i])) {
					result = "NO";
					break;
				}
			}
			System.out.println(result);
		}
	}
}

package BJ;

import java.util.Scanner;

public class BJ_16953_A_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		int num = 1;
		while(true) {
			if(a == b) break;
			if(a > b) {
				num = -1;
				break;
			}
			String temp = b + "";
			if(temp.charAt(temp.length()-1) != '1' && b % 2 != 0) {
				num = -1;
				break;
			}
			if(b % 2 == 0){
				b = b / 2;
			}else {
				temp = temp.substring(0, temp.length()-1);
				b = Long.parseLong(temp);
			}
			num++;
		}
		System.out.println(num);
	}
	
}

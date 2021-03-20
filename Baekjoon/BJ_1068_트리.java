package week01;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1068_트리 {
	static ArrayList<Integer> list; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		int index = sc.nextInt();
		remove(index);
		System.out.println(findLeaf());
	}
	private static void remove(int n) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == n) {
				remove(i);
				list.set(i, 51);
			}
		}
		list.set(n, 51);
	}
	private static int findLeaf() {
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(!list.contains(i) && list.get(i) != 51) count++;
		}
		return count;
	}
	
}

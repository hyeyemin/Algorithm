package programmers;

import java.util.*;

public class Hash_Phone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] book = { "97", "97674223", "1195524421" };
		System.out.println(solution(book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[i].startsWith(phone_book[j]))
					return false;
				if (phone_book[j].startsWith(phone_book[i]))
					return false;
			}
		}
		return answer;
	}

}

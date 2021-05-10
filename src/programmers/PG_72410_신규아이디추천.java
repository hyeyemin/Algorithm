package week07;

import java.util.ArrayList;
import java.util.List;

public class PG_72410_신규아이디추천 {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}

	public static String solution(String new_id) {
		String answer = new_id.toLowerCase();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.length(); i++) {
			char temp = answer.charAt(i);
			if (temp == '-' || temp == '_' || temp == '.')
				sb.append(temp);
			if (temp >= '0' && temp <= '9')
				sb.append(temp);
			if (temp >= 'a' && temp <= 'z')
				sb.append(temp);
		}
		answer = sb.toString();

		List<Character> list = new ArrayList<>();
		for (int i = 0; i < answer.length(); i++) {
			list.add(answer.charAt(i));
		}
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) == '.' && list.get(i - 1) == '.') {
				list.remove(i);
				i--;
			}
		}
		sb = new StringBuilder();
		for (Character ch : list) {
			sb.append(ch);
		}
		answer = sb.toString();

		if (answer.startsWith("."))
			answer = answer.substring(1);
		else if (answer.endsWith("."))
			answer = answer.substring(0, answer.length() - 1);

		if (answer.length() == 0)
			answer = "a";

		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
		}
		if (answer.endsWith("."))
			answer = answer.substring(0, answer.length() - 1);
		
		while(answer.length() <= 2) {
			answer += answer.charAt(answer.length()-1);
		}

		return answer;
	}
}

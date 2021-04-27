package week05;

import java.util.ArrayList;

public class PG_17677_뉴스클러스터링 {
	public static void main(String[] args) {
		String temp = "handshake shake hands aa1+aa2 AAAA12 E=M*C^2 e=m*c^2";
		System.out.println(solution("FRANCE","french"));
	}
	private static int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		addList(list1, str1);
		addList(list2, str2);
		
		double inter = 0;
		double union = 0;
		for(String s : list1) {
			if(list2.remove(s)) {
				inter++;
			}
			union++;
		}
		union += list2.size();
		if(union == 0) answer = 65536;
		else answer = (int)((inter / union) * 65536);
		return answer;
	}
	private static void addList(ArrayList<String> list, String s) {
		for(int i = 0; i < s.length()-1; i++) {
			char a = s.charAt(i);
			char b = s.charAt(i+1);
			
			if(a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z')
				list.add(a+""+b);
		}
	}
}

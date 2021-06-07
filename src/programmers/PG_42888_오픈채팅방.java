package week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG_42888_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	public static String[] solution(String[] record) {
		ArrayList<String> acts = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        for(int i = 0; i < record.length; i++) {
        	String[] words = record[i].split(" ");
        	if(words[0].equals("Enter")) {
        		acts.add(words[1] + "ㅇ님이 들어왔습니다.");
        	}
        	if(words[0].equals("Leave")) {
        		acts.add(words[1] + "ㅇ님이 나갔습니다.");
        	}else users.put(words[1], words[2]);
        }
        String[] answer = new String[acts.size()];
        for(int i = 0; i < answer.length; i++) {
        	String[] words = acts.get(i).split("ㅇ");
        	String user = users.get(words[0]);
        	String act = words[1];
        	answer[i] = user + act;
        }
        return answer;
    }
}

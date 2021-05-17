package week08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class PG_42889_실패율 {
	public static void main(String[] args) {
//		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] stages = {3};
		System.out.println(Arrays.toString(solution(3, stages)));
	}
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] temp = new int[N+2];
        for(int i = 0; i < stages.length; i++) {
        	temp[stages[i]]++;
        }
        int clear[] = new int[N+1];
        clear[1] = stages.length;
        int cnt = temp[1];
        for(int i = 2; i <= N; i++) {
        	if(i > stages.length) break;
        	clear[i] = stages.length - cnt;
        	cnt += temp[i];
        }
        HashMap<Integer, Double> fail = new HashMap<>();
        fail.put(1, (double)stages.length);
        
        for(int i = 1; i <= N; i++) {
        	if(i >= stages.length || temp[i] == 0) fail.put(i, 0.0);
        	else fail.put(i, (double)temp[i] / (double)clear[i]);
        }
        List<Entry<Integer, Double>> entries = new ArrayList<Entry<Integer, Double>>(fail.entrySet());
        Collections.sort(entries, new Comparator<Entry<Integer, Double>>(){
        	public int compare(Entry<Integer, Double> obj1, Entry<Integer, Double> obj2) {
        		if(obj2.getValue() == obj1.getValue()) return obj1.getKey() - obj2.getKey();
        		return obj2.getValue().compareTo(obj1.getValue());
        	}
        });
        int i = 0;
        for(Entry<Integer, Double> entry : entries) {
        	answer[i++] = entry.getKey();
        }
        return answer;
    }
}

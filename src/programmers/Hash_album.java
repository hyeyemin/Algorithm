package programmers;
import java.util.*;
public class Hash_album {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"d","classic", "pop", "classic", "classic", "pop"};
		int[] plays = {8000, 500, 600, 150, 800, 2500};
		for(int i=0; i<solution(genres, plays).length; i++) {
			System.out.println(solution(genres, plays)[i]);
		}
	}
	public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<String, Integer> song = new HashMap<>(); 
        HashMap<String, Integer> total = new HashMap<>();
        ArrayList<Integer> total_array = new ArrayList<>();
        for(int i=0; i<genres.length; i++) {
        	if(total.containsKey(genres[i])) {
        		total.put(genres[i], total.get(genres[i])+plays[i]);
        	}else {
        		total.put(genres[i], plays[i]);
        	}
        	song.put(genres[i]+" "+i, plays[i]);
        }
        for(Map.Entry<String, Integer> entry: total.entrySet()) {
        	total_array.add(entry.getValue());
        }
        Collections.sort(total_array);
        Collections.reverse(total_array);
        String first = "";
        String second = "";
        for(Map.Entry<String, Integer> entry: total.entrySet()) {
        	if(total_array.get(0) == entry.getValue()) {
        		first = entry.getKey();
        	}
        	if(total_array.get(1) == entry.getValue()) {
        		second = entry.getKey();
        	}
        }
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        for(int i=0; i<song.size(); i++) {
        	if(song.containsKey(first+" "+i)) {
        		array1.add(song.get(first+" "+i));
        	}else if(song.containsKey(second+" "+i)) {
        		array2.add(song.get(second+" "+i));
        	}
        }
        Collections.sort(array1);
        Collections.reverse(array1);
        Collections.sort(array2);
        Collections.reverse(array2);
        for(Map.Entry<String, Integer> entry: song.entrySet()) {
        	if(temp.size()==0&&entry.getKey().contains(first)&&array1.get(0)==entry.getValue()) {
        		temp.add(Integer.parseInt(entry.getKey().split(" ")[1]));
        	}else if(temp.size()<2&&entry.getKey().contains(first)&&array1.get(1)==entry.getValue()) {
        		temp.add(Integer.parseInt(entry.getKey().split(" ")[1]));
        	}
        }
        for(Map.Entry<String, Integer> entry: song.entrySet()) {
        	if(temp.size()<3&&entry.getKey().contains(second)&&array2.get(0)==entry.getValue()) {
        		temp.add(Integer.parseInt(entry.getKey().split(" ")[1]));
        	}else if(temp.size()<3&&entry.getKey().contains(second)&&array2.get(1)==entry.getValue()) {
        		temp.add(Integer.parseInt(entry.getKey().split(" ")[1]));
        	}
        }
    	
        int[] answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++) {
        	answer[i] = temp.get(i);
        }
        return answer;
    }
}

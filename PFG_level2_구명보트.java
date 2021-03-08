import java.util.Arrays;

public class PFG_level2_구명보트 {
	public static void main(String[] args) {
		int[] people = {70};
		System.out.println(solution(people, 100));
	}
	public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int checknum = 0;
        int current = 0;
        while(true) {
        	if(checknum > people.length-1-current) {
        		break;
        	}else if(checknum == people.length-1-current) {
        		answer++;
        		break;
        	}
        	int result = people[people.length-1-current];
        	int min = people[checknum];
        	while(result + min <= limit) {
        		if(checknum > people.length-1-current) {
            		break;
            	}else if(checknum == people.length-1-current) {
            		answer++;
            		break;
            	}
        		min += people[++checknum];
        	}
        	answer++;
        	current++;
        }
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : people) {
        	list.add(i);
        }
        Collections.sort(list);
        while(!list.isEmpty()) {
        	int result = list.get(list.size()-1);
        	if(list.size() == 1) {
        		answer++;
        		break;
        	}
        	int min = list.get(0);
        	while(result+min <= limit) {
        		if(list.size() == 1){
        			break;
        		}
        		list.remove(0);
        		result += list.get(0);
        	}
        	answer++;
        	list.remove(list.size()-1);
        }*/
        return answer;
    }
}

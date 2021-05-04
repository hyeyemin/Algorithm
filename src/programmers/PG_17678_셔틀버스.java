package week06;

import java.util.Arrays;

public class PG_17678_셔틀버스 {
	public static void main(String[] args) {
//		String[] timetable = {"09:10", "09:09", "08:00"};
		String[] timetable = {"09:01", "09:01", "09:01", "09:01", "09:01"};
//		String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		System.out.println(solution(1,1,5,timetable));
	}
	 public static String solution(int n, int t, int m, String[] timetable) {
	        String answer = "";
	        int[] times = new int[timetable.length];
	        for(int i = 0; i < timetable.length; i++) {
	        	times[i] = Integer.parseInt(timetable[i].substring(0,2)) * 60 + Integer.parseInt(timetable[i].substring(3,5));
	        }
	        Arrays.sort(times);
			int[] bus = new int[n];
			for(int i = 0; i < n; i++) {
				bus[i] = 540 + i * t;
			}

			int[][] people = new int[n][m];
			int[] cnt = new int[n];
			for(int i = 0; i < times.length; i++) {
				for(int j = 0; j < n; j++) {
					if(times[i] <= bus[j]) {
						if(cnt[j] >= m) {
							continue;
						}
						people[j][cnt[j]++] = times[i];
						break;
					}
				}
			}
			int hour = 0;
			int min = 0;
			if(cnt[n-1] >= m) {
				hour = people[n-1][m-1]/60;
				min = people[n-1][m-1]%60;
				if( min < 1 ) {
					answer = ""+( hour - 1 > 9 ? hour-1 : "0"+(hour-1))
							+":59"; 
				}else {							
					answer = ""+ ( hour > 9 ? hour : "0" + hour )
							+":"+( min-1 > 9 ? min-1 : "0"+(min-1));
				}
				
			}else {
				answer = ""+((bus[n-1]/60) > 9 ? (bus[n-1]/60) : "0"+(bus[n-1]/60))
						+":"+( (bus[n-1]%60)-1 > 9 ? (bus[n-1]%60) : "0"+(bus[n-1]%60));
			}
	        return answer;
	    }
}

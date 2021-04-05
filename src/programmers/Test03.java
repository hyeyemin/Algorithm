package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test03 {
	static Queue<Integer> q;
	static ArrayList<Integer>[] list;
	static int[] dist;
	public static void main(String[] args) {
		int[] passenger = {1,1,1,1,1,1};
		int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
//		int[] passenger = {1,1,1,1,1,1};
//		int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
//		int[] passenger = {1,1,1,1,1,1};
//		int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
		System.out.println(Arrays.toString(solution(6,passenger,train)));
	}
	public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];
        q = new LinkedList<>();
        list = new ArrayList[n+1];
        dist = new int[n+1];
        dist[1] = passenger[0];
        for(int i = 1; i <= n; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i = 0; i < train.length; i++) {
        	list[train[i][0]].add(train[i][1]);
        	if(train[i][0] == 1) {
        		q.offer(train[i][1]);
        		dist[train[i][1]] = dist[1] + passenger[train[i][1]-1];
        	}
        }
        go(passenger);
        int max = 0;
        for(int i = 1; i <= n; i++) {
        	if(max <= dist[i]) {
        		answer[0] = i;
        		answer[1] = dist[i];
        	}
        }
        return answer;
    }
	private static void go(int[] passenger) {
		while(!q.isEmpty()) {
			int station = q.poll();
			for(int i = 0; i < list[station].size(); i++) {
				int temp = list[station].get(i);
				dist[temp] = dist[station] + passenger[temp-1];
				q.offer(temp);
			}
		}
	}
}

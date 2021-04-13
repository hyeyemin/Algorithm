package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1956_운동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		long[][] dist = new long[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				dist[i][j] = (long)1e18;
			}
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = c;
		}
		for(int k = 0; k < V; k++) {
			for(int i = 0; i < V; i++) {
				if(i == k) continue; 
				for(int j = 0; j < V; j++) {
					if(i==j || k==j) continue;
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		long min = (long)1e18;
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				min = Math.min(dist[i][j] + dist[j][i], min);
			}
		}
		if(min == (long)1e18) System.out.println(-1);
		else System.out.println(min);
	}
}

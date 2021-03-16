package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_4358_생태학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Double> map = new HashMap<>();
		String temp = "";
		int total = 0;
		while((temp = br.readLine()) != null) {
			total++;
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp)+1);
			}else {
				map.put(temp, 1.0);
			}
		}
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);
		
		for(int i = 0; i < map.size(); i++) {
			System.out.println(mapkey[i] + " " + String.format("%.4f",(map.get(mapkey[i]) / total * 100)));
		}
		
	}
}

package scf;
import java.io.*;
public class Test01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] time = new String[n][2];
		String start = "0000";
		String end = "2359";
		for(int i = 0; i < n; i++) {
			String[] temp = br.readLine().replace(":", "").split(" ~ ");
			time[i][0] = temp[0];
			if(Integer.parseInt(start) < Integer.parseInt(time[i][0])) {
				start = time[i][0];
			}
			time[i][1] = temp[1];
			if(Integer.parseInt(end) > Integer.parseInt(time[i][1])) {
				end = time[i][1];
			}
		}
		if(Integer.parseInt(start) > Integer.parseInt(end)) System.out.println(-1);
		else System.out.println(start.substring(0,2) + ":" + start.substring(2,4) + " ~ " + end.substring(0,2) + ":" + end.substring(2,4));
	}
}

import java.util.Scanner;

public class SW_8382_D4_방향전환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int result = 0;
			int width = Math.abs(x1-x2);
			int height = Math.abs(y1-y2);
			if(Math.abs(width-height) == 1 || width == height) {
				result = width + height;
			}else {
				if(width >= height) {
					if((width-height) % 2 == 0) result = width * 2;
					else result = width * 2 - 1;
				}else {
					if((height-width) % 2 == 0) result = height * 2;
					else result = height * 2 - 1;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}

import java.util.Scanner;

public class BJ_2304_창고다각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[N][2];
		int maxL = 0, maxH = 0, maxHIndex = 0;
		for(int n = 0; n < N; n++) {
			arr[n][0] = sc.nextInt();
			maxL = Math.max(maxL, arr[n][0]);
			arr[n][1] = sc.nextInt();
			if(maxH < arr[n][1]) {
				maxH = arr[n][1];
				maxHIndex = arr[n][0];
			}
		}
		int map[][] = new int[maxL+1][maxH];
		for(int n = 0; n < N; n++) {
			for(int h = 0; h < arr[n][1]; h++) {
				map[arr[n][0]][h] = 1;
			}
		}
		for(int j = 0; j < maxH; j++) {
			for(int i = 1; i <= maxHIndex; i++) {
				if(map[i-1][j] == 1) map[i][j] = 1;
			}
		}
		for(int j = 0; j < maxH; j++) {
			for(int i = maxL; i > maxHIndex; i--) {
				if(map[i][j] == 1) map[i-1][j] = 1;
			}
		}
		int result = 0;
		for(int i = 0; i < maxL+1; i++) {
			for(int j = 0; j < maxH; j++) {
				if(map[i][j] == 1) result++;
			}
		}
		System.out.println(result);
	}
}

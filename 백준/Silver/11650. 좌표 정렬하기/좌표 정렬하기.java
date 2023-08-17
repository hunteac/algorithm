import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 람다식을 활용한 배열 정렬
		Arrays.sort(map, (e1, e2) -> {
				if (e1[0] == e2[0]) {
					return e1[1] - e2[1];
				} else {
					return e1[0] - e2[0];
				}
		});
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
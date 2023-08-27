import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[1001][1001]; // 격자
		int T = sc.nextInt(); // 색종이 수
		int xmax = 0; // 최대 x좌표
		int ymax = 0; // 최대 y좌표
		int sum = 0;
		for (int tc = 1; tc <= T; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();
			int r = sc.nextInt();
			xmax = Math.max(xmax, x + c); // 최대 x좌표 구하기
			ymax = Math.max(ymax, y + r); // 최대 y좌표 구하기
			for (int i = x; i < x + c; i++) {
				for (int j = y; j < y + r; j++) {
					map[i][j] = tc; // 번호 별 색종이 면적 담기
				}
			}
		}
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < xmax; i++) {
				for (int j = 0; j < ymax; j++) {
					if (map[i][j] == tc)
						sum++; // 번호 별 색종이 면적 구하기
				}
			}
			System.out.println(sum);
			sum = 0;
		}
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int sum = 0; // 합집합 면적
		int xmax = 0; // x좌표 최댓값
		int ymax = 0; // y좌표 최댓값
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt(); 
			int x2 = sc.nextInt(); 
			int y2 = sc.nextInt();
			xmax = Math.max(xmax, x2);
			ymax = Math.max(ymax, y2);
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[j][k]++; // 해당 좌표에 등장하는 직사각형 수
				}
			}
		}
		for (int i = 0; i < xmax; i++) {
			for (int j = 0; j < ymax; j++) {
				if (map[i][j] != 0) 
					sum++; // 해당 좌표에 직사각형이 있다면 +1
			}
		}
		System.out.println(sum);
	}
}
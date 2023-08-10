import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] pz = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					pz[i][j] = sc.nextInt();
				}
			}
			// 퍼즐을 9칸으로 나누어 각 칸의 중앙값과 다른 값들을 비교하기 위한
			// dr, dc(상하좌우) / dr2, dc2(대각선) 배열 선언
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int[] dr2 = { -1, -1, 1, 1 };
			int[] dc2 = { -1, 1, -1, 1 };
			// 중복 횟수를 구하는 변수 선언 및 초기화
			int cnt = 0;
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					for (int k = 0; k < 4; k++) {
						if (pz[i + 1][j + 1] == pz[i + 1 + dr[k]][j + 1 + dc[k]])
							cnt++;
						if (pz[i + 1][j + 1] == pz[i + 1 + dr2[k]][j + 1 + dc2[k]])
							cnt++;
					}
				}
			}
			// 열에서 중복된 숫자를 확인하기 위한 반복문
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					for (int k = j + 1; k < 9; k++) {
						if (pz[i][j] == pz[i][k])
							cnt++;
					}
				}
			}
			// 행에서 중복된 숫자를 확인하기 위한 반복문
			for (int j = 0; j < 9; j++) {
				for (int i = 0; i < 9; i++) {
					for (int k = i + 1; k < 9; k++) {
						if (pz[i][j] == pz[k][j])
							cnt++;
					}
				}
			}
			if (cnt == 0) // 중복 횟수가 0이면
				System.out.printf("#%d %d\n", test_case, 1);
			else
				System.out.printf("#%d %d\n", test_case, 0);
		}
		sc.close();
	}
}
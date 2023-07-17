import java.util.Scanner;

class Solution {
	public static boolean count(char[][] matrix, int len, int cnt, int i, int j) {
		int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
		int temp = 0; // 클릭한 위치의 주변 지뢰 개수 계산.
		for (int[] dir : direction) {
			int row = dir[0] + i;
			int col = dir[1] + j;
			if (0 <= row && row < len && 0 <= col && col < len && matrix[row][col] == '*') {
				temp++;
			}
		}
		if (cnt == 1) { // cnt가 1인 경우는 이전 클릭에서 0이 나온 경우로 주변 지뢰의 수를 입력하되, 클릭 횟수에 카운트하지 않는다.
			matrix[i][j] = (char) (temp + '0');
		}

		if (temp == 0) {
			matrix[i][j] = (char) (temp + '0');
			for (int[] dir : direction) {
				int row = dir[0] + i;
				int col = dir[1] + j;
				if (0 <= row && row < len && 0 <= col && col < len && matrix[row][col] == '.') {
					count(matrix, len, 1, row, col); // 클릭한 위치의 주변 지뢰 개수가 0이라면 재귀문을 통해 인접한 칸의 지뢰 개수를 표시한다. 이때 cnt값을 1로 설정하여 이전 클릭이 0이었음을 기록한다. 
				}
			}
			return true; // 클릭한 위치의 주변 지뢰 개수가 0인경우 인접한 칸의 숫자가 자동으로 나온다. 이때 클릭 횟수는 1회이다.
		}
		return false; //  주변에 지뢰가 존재하는 경우 처리되지 않은 경우로 남겨 나중에 더한다.
	}

	public static int bfs(char[][] matrix, int len) {
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (matrix[i][j] == '.') {
					if (count(matrix, len, 0, i, j)) { // 클릭한 위치의 주변 지뢰 개수가 0인 경우만 1을 더한다. 
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
			sc.nextLine();

			char[][] matrix = new char[len][len];
			for (int i = 0; i < len; i++) {
				matrix[i] = sc.nextLine().toCharArray();
			}

			int result = bfs(matrix, len); 
			for (char[] row : matrix) {
				for (char ch : row) {
					if (ch == '.') {
						result++; // 아직 처리되지 않은 경우 카운트
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, result);

		}
		sc.close();
	}
}
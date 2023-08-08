import java.util.Scanner;

public class Main {
	// 주어진 체스판(board)에서 (col, row) 위치를 시작으로 8x8 크기의 체스판을 만들었을 때,
	// 색을 변경하는 최소 횟수를 계산하는 함수
	public static int paint(String[][] board, String bw, int col, int row) {
		int cnt1 = 0;
		int cnt2 = 0;
		int num = 0;
		// (col, row) 위치부터 8x8 크기의 체스판을 만들고 칠하는 횟수 구하기
		for (int i = col; i < col + 8; i += 2) {
			for (int j = row; j < row + 8; j += 2) {
				// 체스판 네칸 중 왼쪽 위를 기준으로 계산
				if (!(board[i][j].equals(bw)))
					cnt1++;
				if (board[i][j + 1].equals(bw))
					cnt1++;
				if (board[i + 1][j].equals(bw))
					cnt1++;
				if (!(board[i + 1][j + 1].equals(bw)))
					cnt1++;
				// 체스판 네칸 중 오른쪽 아래를 기준으로 계산
				if (board[i][j].equals(bw))
					cnt2++;
				if (!(board[i][j + 1].equals(bw)))
					cnt2++;
				if (!(board[i + 1][j].equals(bw)))
					cnt2++;
				if (board[i + 1][j + 1].equals(bw))
					cnt2++;
			}
		}
		if (cnt1 >= cnt2)
			num = cnt2;
		else
			num = cnt1;
		return num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		String[][] board = new String[m][n];

		for (int i = 0; i < m; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j) + "";
			}
		}
		int min = m * n;
		// 가능한 모든 8x8 크기의 체스판을 만들어가며 최소 횟수 계산
		for (int i = 0; i <= m - 8; i++) {
			for (int j = 0; j <= n - 8; j++) {
				int result = paint(board, board[i][j], i, j);
				if (result < min)
					min = result;
			}
		}
		System.out.println(min);
		sc.close();
	}
}
import java.io.IOException;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			char[][] board = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String str = sc.next(); // 공백이 없는 입력을 받기 위한 문자열 변수 선언
				for (int j = 0; j < 100; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			System.out.println("#" + n + " " + palindromeMax(board));
		}
	}
	static int max = 0;
	static int cnt = 0;
	static int r = 1;
	static int c = 1;
	public static int palindromeMax(char[][] board) {
		max = 0;
		r = 1;
		c = 1;
		for (int i = 0; i < 100; i++) {
			cnt = 0;
			for (int j = 0; j < 100; j++) {
				c = 1;
				if (j - 1 >= 0 && j + 1 < 100 && board[i][j - 1] == board[i][j + 1]) { // 행에 존재하는 palindrome의 최대 길이 구하기
					cnt += 3;
					while(true) {
						if (j - 1 - c >= 0 && j + 1 + c < 100 && board[i][j - 1 - c] == board[i][j + 1 + c])
							cnt += 2;
						else
							break;
						c++;
					}
					if (cnt > max) max = cnt;
				}
				cnt = 0;
				r = 1;
				if (j - 1 >= 0 && j + 1 < 100 && board[j - 1][i] == board[j + 1][i]) { // 열에 존재하는 palindrome의 최대 길이 구하기
					cnt += 3;
					while(true) {
						if (j - 1 - r >= 0 && j + 1 + r < 100 && board[j - 1 - r][i] == board[j + 1 + r][i])
							cnt += 2;
						else
							break;
						r++;
					}
					if (cnt > max) max = cnt;
				}
				cnt = 0;
				c = 1;
				if (j + 1 < 100 && board[i][j] == board[i][j + 1]) { // 열에 존재하는 palindrome의 최대 길이 구하기
					cnt += 2;
					while(true) {
						if (j - c >= 0 && j + 1 + c < 100 && board[i][j - c] == board[i][j + 1 + c])
							cnt += 2;
						else
							break;
						c++;
					}
					if (cnt > max) max = cnt;
				}
				cnt = 0;
				r = 1;
				if (j + 1 < 100 && board[j][i] == board[j + 1][i]) { // 열에 존재하는 palindrome의 최대 길이 구하기
					cnt += 2;
					while(true) {
						if (j - r >= 0 && j + 1 + r < 100 && board[j - r][i] == board[j + 1 + r][i])
							cnt += 2;
						else
							break;
						r++;
					}
					if (cnt > max) max = cnt;
				}
				cnt = 0;
			}
		}
		return max;
	}
}
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt(); // 퍼즐의 크기
			int k = sc.nextInt(); // 글자수
			int[][] pz = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					pz[i][j] = sc.nextInt();
				}
			}
			int cnt1 = 0; // 빈칸수 구하기
			int cnt2 = 0; // 자리수 구하기
			// 행 우선순회
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (pz[i][j] == 0)
						cnt1 = 0;
					if (pz[i][j] == 1)
						cnt1++;
					if (cnt1 == k) // 빈칸수랑 글자수가 같을 경우
						cnt2++;
					if (cnt1 > k) { // 빈칸수가 글자수보다 클 경우
						cnt2--;
						cnt1 = 0;
					}
				}
				cnt1 = 0;
			}
			// 열 우선순회
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					if (pz[i][j] == 0)
						cnt1 = 0;
					if (pz[i][j] == 1)
						cnt1++;
					if (cnt1 == k) // 빈칸수랑 글자수가 같을 경우
						cnt2++;
					if (cnt1 > k) { // 빈칸수가 글자수보다 클 경우
						cnt2--;
						cnt1 = 0;
					}
				}
				cnt1 = 0;
			}
			System.out.printf("#%d %d\n", test_case, cnt2);
		}
		sc.close();
	}
}
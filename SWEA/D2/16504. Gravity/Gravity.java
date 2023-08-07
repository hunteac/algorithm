import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int cnt = 0; // 감소하는 순서쌍의 개수를 세는 변수
			int max = 0; // 최대 감소하는 순서쌍의 개수를 저장하는 변수

			// 모든 i에 대해 i번째 원소와 i+1번째 원소를 비교하여 감소하는 순서쌍의 개수 세기
			for (int i = 0; i < n - 1; i++) {
				cnt = 0;
				for (int j = i + 1; j < n; j++) {
					if (arr[i] > arr[j]) {
						cnt++;
					}
					if (cnt > max) {
						max = cnt; // 최대 감소하는 순서쌍 개수 갱신
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
		sc.close();
	}
}
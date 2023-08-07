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

			int cnt = 0;
			int max = 0;
			for (int i = 0; i < n - 1; i++) {
				cnt = 0;
				for (int j = i + 1; j < n; j++) {
					if (arr[i] > arr[j]) {
						cnt++;
					}
					if (cnt > max) {
						max = cnt;
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
		sc.close();
	}
}
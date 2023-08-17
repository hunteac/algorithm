import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = sc.nextInt();
			int n = sc.nextInt(); // 곱하는 수
			int m = sc.nextInt(); // 거듭제곱 횟수
			System.out.printf("#%d %d\n", num, multiple(n, m));
		}
	}
	// 재귀호출 활용
	public static int multiple(int n, int m) {
		if (m == 0) return 1;
		m--;
		return n * multiple(n, m);
	}
}	
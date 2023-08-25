import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			int max = -1;
			for (int i = 0; i < N; i++) {
				Out: for (int j = i + 1; j < N; j++) {
					int num = nums[i] * nums[j];
					int tmp = num;
					while (tmp != 0) {
						int a = tmp % 10;
						tmp = tmp / 10;
						int b = tmp % 10;
						if (a < b) // 단조 증가 수가 아니라면
							continue Out;
					}
					// 단조 증가 수 조건을 충족하면 최댓값과 비교
					max = Math.max(max, num);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
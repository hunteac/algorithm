import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 선택정렬 사용
		int minIdx = 0;
		int temp = 0;
		for (int i = 0; i < n - 1; i++) {
			minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
				temp = arr[minIdx];
				arr[minIdx] = arr[j];
				arr[j] = temp;
			}
		}
		System.out.println(arr[n / 2]);
		sc.close();
	}
}
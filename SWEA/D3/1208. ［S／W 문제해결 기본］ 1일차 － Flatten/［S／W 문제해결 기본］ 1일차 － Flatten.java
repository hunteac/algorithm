import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			int max = 0;
			int min = 101;
			int maxIdx = 0; // 최대 높이의 인덱스를 저장할 변수
			int minIdx = 0; // 최소 높이의 인덱스를 저장할 변수
			// 평탄화 횟수만큼 반복
			for (int i = 0; i < n; i++) {
				max = 0;
				min = 101;
				// 배열의 높이를 순회하며 최대와 최소 높이 및 각각의 인덱스 찾기
				for (int j = 0; j < 100; j++) {
					if (arr[j] > max) {
						max = arr[j];
						maxIdx = j;
					}
					if (arr[j] < min) {
						min = arr[j];
						minIdx = j;
					}
				}
				arr[maxIdx] -= 1; // 최대 높이에서 블록 하나 제거
				arr[minIdx] += 1; // 최소 높이에 블록 하나 추가
			}
			Arrays.sort(arr);
			System.out.printf("#%d %d\n", test_case, arr[arr.length - 1] - arr[0]);
		}
		sc.close();
	}
}
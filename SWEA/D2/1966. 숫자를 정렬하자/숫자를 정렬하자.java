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
			// 선택정렬 메소드 사용
			selectionSort(arr);

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("%d ", arr[i]);
			}
			System.out.println();
		}
		sc.close();
	}

	// 선택 정렬 기능을 가진 selectionSort 메소드 구현
	public static void selectionSort(int[] arr) {
		int minIdx = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
	}
}
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 숫자열 길이 입력
			int N = sc.nextInt();
			// 숫자들을 담을 배열 선언
			int[] nums = new int[N];
			// 배열에 숫자 담기
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			// 삽입 정렬 사용
			for (int i = 1; i < N; i++) {
				int key = nums[i];
				int j;
				for (j = i - 1; j >= 0 && key < nums[j]; j--) {
					nums[j + 1] = nums[j];
				}
				nums[j + 1] = key;
			}
			System.out.print("#" + test_case + " ");
			// for each를 통한 배열 출력
			for (int i : nums) {
				System.out.print(i + " ");
			}
			System.out.println();
		} 
	}	
}	
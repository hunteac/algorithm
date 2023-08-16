import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			char[] arr = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			int bar = 0; // 현재 구역의 쇠 막대기 수
			int sum = 0; // 잘린 막대기 수 총합
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == '(') {
					if (arr[i + 1] == '(') { // '(' 두번 등장 시
						bar++; // 막대기 수 증가
						sum++; // 막대기 수 총합 증가
					} else { // 레이저 등장 시
						sum += bar; // 자른 막대기 수 증가
					}
				} else {
					if (arr[i + 1] == ')') // ')' 두번 등장 시
						bar--; // 막대기 수 감소
				}
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}
}	
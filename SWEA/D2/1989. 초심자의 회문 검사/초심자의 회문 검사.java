import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next(); // 문자열 입력 받기
			int ans = 1;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					ans = 0;
					break;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			int cnt1 = 0;
			int cnt2 = 0;
			String str1 = sc.next();
			String snt = sc.next();
			for (int i = 0; i < snt.length() - str1.length() + 1; i++) {
				cnt1 = 0;
				if (str1.charAt(0) == snt.charAt(i)) {
					cnt1++;
					for (int j = i; j < str1.length() + i - 1; j++) {
						if (str1.charAt(1 + j - i) == snt.charAt(j + 1))
							cnt1++;
					}
				}
				if (cnt1 == str1.length())
					cnt2++;
			}
			System.out.println("#" + test_case + " " + cnt2);
		}
	}
}
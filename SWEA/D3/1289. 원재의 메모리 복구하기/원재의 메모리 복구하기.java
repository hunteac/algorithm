import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 메모리 bit 입력
			String s = br.readLine();
			char[] bit = new char[s.length()];
			for (int i = 0; i < bit.length; i++) {
				bit[i] = '0';
			}
			// 원래 상태로 되돌리는 최소 횟수
			int cnt1 = 0;
			// 변경한 상태가 원래 상태인지 확인하는 변수
			int cnt2 = 0;
			for (int i = 0; i < bit.length; i++) {
				// bit 값이 다르면
				if (bit[i] != s.charAt(i)) {
					cnt1++;
					// 해당 bit 값부터 뒤까지 모두 변경
					for (int j = i; j < bit.length; j++) {
						bit[j] = s.charAt(i);
					}
				}
				// 변경한 상태가 원래 상태인지 확인하는 반복문
				for (int j = 0; j < bit.length; j++) {
					if (s.charAt(j) == bit[j])
						cnt2++;
				}
				// 원래 상태랑 동일하다면 반복문 탈출
				if (cnt2 == s.length())
					break;
				cnt2 = 0;
			}
			System.out.println("#" + tc + " " + cnt1);
		}
	}
}
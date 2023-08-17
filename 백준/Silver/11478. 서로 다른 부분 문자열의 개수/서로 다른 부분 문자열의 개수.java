import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 중복된 원소를 제거하기 위한 Set 활용
		Set<String> strSet = new HashSet<>();
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				// 전체 문자열의 부분 문자열 구하기
				strSet.add(s.substring(i, j));
			}
		}
		// 서로 다른 부분 문자열 개수 출력
		System.out.println(strSet.size());
	}
}
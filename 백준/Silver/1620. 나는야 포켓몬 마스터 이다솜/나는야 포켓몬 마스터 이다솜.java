import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<Integer, String> nameInt = new HashMap<>();
		HashMap<String, Integer> nameStr = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			nameInt.put(i, name);
			nameStr.put(name, i);
		}
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (isNum(s)) { // s가 숫자라면 nameInt Map을 활용해 해당 이름 Value 출력
				sb.append(nameInt.get(Integer.parseInt(s))).append("\n");
			} else { // s가 문자열이라면 nameStr Map을 활용해 해당 숫자 Value 출력
				sb.append(nameStr.get(s)).append("\n");
			}
		}
		System.out.println(sb);
	}
	// 입력받은 s가 숫자인지 판단하는 메소드
	public static boolean isNum(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!(Character.isDigit(s.charAt(i))))
				return false;
		}
		return true;
	}
}
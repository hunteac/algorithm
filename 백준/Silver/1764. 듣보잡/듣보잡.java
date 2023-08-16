import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> nameSet = new HashSet<>();
		List<String> nameList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nameSet.add(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (nameSet.contains(name)) {
				nameList.add(name);
				cnt++;
			}
		}
		Collections.sort(nameList); // 이름 사전순으로 정렬
		System.out.println(cnt);
		for (String name : nameList) {
			sb.append(name).append("\n");
		}
		System.out.println(sb);
	}
}
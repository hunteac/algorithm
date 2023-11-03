import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Map<String, Integer> map = new HashMap<>(); // 의상 종류별 수
			
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 1) + 1);
			}
			
			int sum = 1;
			
			for (String s : map.keySet()) {
				sum *= map.get(s);
			}

			sb.append(sum - 1).append("\n");
		}
		
		System.out.println(sb);
	}
}
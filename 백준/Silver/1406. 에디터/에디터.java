import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int curr = sb.length(); // 커서 위치
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			String c = order.equals("P") ? st.nextToken() : "";
			
			switch (order) {
				case "L":
					curr = curr != 0 ? --curr : curr;
					break;
				case "D":
					curr = curr != sb.length() ? ++curr : curr;
					break;
				case "B":
					if (curr != 0) sb.deleteCharAt(--curr);
					break;
				case "P":
					sb.insert(curr, c);
					curr = curr != N ? ++curr : curr;
					break;
			}
		}
		
		System.out.println(sb);
	}
}
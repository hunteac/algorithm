import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			
			int score = 0;
			int cnt = 1; // 연속된 O개수
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'O') {
					score += cnt;
					cnt++;
				} else {
					cnt = 1;
				}
			}
			
			sb.append(score).append("\n");
		}
		
		System.out.println(sb);
	}
}
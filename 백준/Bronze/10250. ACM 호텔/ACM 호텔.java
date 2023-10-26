import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken()); // 층
			int W = Integer.parseInt(st.nextToken()); // 방 개수
			int N = Integer.parseInt(st.nextToken());
			
			String room = "";
			
			for (int i = 1; i <= W; i++) {
				for (int j = 1; j <= H; j++) {
					N--; // 방 배정
					if (N == 0) {
						room += String.valueOf(j);
						if (i < 10) room += "0" + String.valueOf(i);
						else room += String.valueOf(i);
					}
				}
			}
			
			sb.append(room).append("\n");
		}
		
		System.out.println(sb);
	}
}
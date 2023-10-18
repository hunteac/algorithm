import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String time = st.nextToken();
			int D = Integer.parseInt(st.nextToken()); // 통화 시간
			
			int h = Integer.parseInt(time.substring(0, 2)); // 시
			int m = Integer.parseInt(time.substring(3, 5)); // 분
			
			for (int j = 1; j <= D; j++) {
				if (m == 60) { // 시 +1
					h += 1;
					m = 0;
				}
				
				h %= 24; // 24시: 00시
				
				if (h >= 7 && h < 19) sum += 10; 
				else sum += 5;
				
				m++;
			}
		}
		
		System.out.println(sum);
	}
}

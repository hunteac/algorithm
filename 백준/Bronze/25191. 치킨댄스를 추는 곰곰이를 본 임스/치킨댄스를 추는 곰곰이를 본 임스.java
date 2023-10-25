import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()); // 콜라 개수
		int B = Integer.parseInt(st.nextToken()); // 맥주 개수
		
		int cnt = 0;
		
		while (true) {
			if (A >= 2) { // 콜라와 함께 먹기
				A -= 2;
				N--;
				cnt++;
			} else if (B > 0) { // 맥주와 함께 먹기
				B--;
				N--;
				cnt++;
			}
			if ((A < 2 && B == 0) || N == 0) break; // 더이상 먹을 수 없으면 종료
		}

		System.out.println(cnt);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] cnt = new int[41][2];
	
	static int zerofibo (int n) {
		if (n >= 2 && cnt[n][0] == 0) {
			return cnt[n][0] = zerofibo(n - 1) + zerofibo(n - 2);
		}
		
		return cnt[n][0];
	}
	
	static int onefibo (int n) {
		if (n >= 2 && cnt[n][1] == 0) {
			return cnt[n][1] = onefibo(n - 1) + onefibo(n - 2);
		}
		
		return cnt[n][1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		cnt[0][0] = 1;
		cnt[0][1] = 0;
		cnt[1][0] = 0;
		cnt[1][1] = 1;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			zerofibo(N);
			onefibo(N);
			
			sb.append(cnt[N][0] + " " + cnt[N][1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
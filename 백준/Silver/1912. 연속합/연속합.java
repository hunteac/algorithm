import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dp = new int[n];
		
		int max = -1000; // 연속 합 최댓값
		
		// 동적계획법
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (i == 0) dp[i] = num;
			// 기존 누적합과 현재 값의 합이 현재 값보다 큰 경우
			else if (dp[i - 1] + num > num) dp[i] = dp[i - 1] + num;
			// 기존 누적합과 현재 값의 합이 현재 값보다 작은 경우: 값 갱신
			else dp[i] = num; 
			
			max = Math.max(max, dp[i]); // 최댓값 구하기
		}
		
		System.out.println(max);
	}
}

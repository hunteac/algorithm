import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		
		for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(coins); // 오름차순 정렬
		
		int cnt = 0; // 동전 최소 개수
		int change = num; // 거스름돈
		
		for (int i = N - 1; i >= 0; i--) {
			if (coins[i] > change) continue;
			
			cnt += change / coins[i];
			int tmp = change / coins[i];
			change -= coins[i] * tmp;

			if (change == 0) break;
		}
		
		System.out.println(cnt);
	}
}
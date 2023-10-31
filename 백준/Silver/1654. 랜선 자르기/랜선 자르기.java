import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[K];
		
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}
		
		long left = 1;
		long right = Integer.MAX_VALUE;
		
		long cnt, mid;
		
		// 이분탐색
		while (left <= right) {
			cnt = 0;
			mid = (left + right) / 2;
			
			for (int i = 0; i < K; i++) {
				cnt += lan[i] / mid;
			}
					
			// 범위 절반으로 줄이기
			if (cnt < N) right = mid - 1;
			else left = mid + 1;
		}
		
		System.out.println(right);
	}
}
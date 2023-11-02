import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] nums = new int[11];
		
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 4;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			if (nums[N] != 0) {
				sb.append(nums[N]).append("\n");
				continue;
			}
			
			for (int i = 4; i <= N; i++) {
				nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
			}
			
			sb.append(nums[N]).append("\n");
		}
		
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] nums = new int[3];
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			nums[0] = Integer.parseInt(st.nextToken());
			nums[1] = Integer.parseInt(st.nextToken());
			nums[2] = Integer.parseInt(st.nextToken());
			
			if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) break;
			
			boolean chk = false;

			Arrays.sort(nums); // 오름차순 정렬
			
			// 직각삼각형 공식 성립
			if (Math.pow(nums[2], 2) == Math.pow(nums[0], 2) + Math.pow(nums[1], 2))
				chk = true;
			
			if (chk) sb.append("right").append("\n");
			else sb.append("wrong").append("\n");
		}
		
		System.out.println(sb);
	}
}
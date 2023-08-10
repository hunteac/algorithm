import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		int[] cnts = new int[10000 + 1];
		for (int i = 0; i < n; i++) {
			cnts[nums[i]]++;
		}
		for (int i = 0; i < cnts.length - 1; i++) {
			cnts[i + 1] += cnts[i];
		}
		int[] result = new int[n];
		for (int i = nums.length - 1; i >= 0; i--) {
			cnts[nums[i]]--;
			result[cnts[nums[i]]] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
}
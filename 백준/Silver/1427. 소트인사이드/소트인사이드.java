import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int[] nums = new int[s.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(s.charAt(i) + "");
		}
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		System.out.println(sb);
	}
}
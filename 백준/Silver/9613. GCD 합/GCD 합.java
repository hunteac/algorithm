import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] nums = new int[n];
			
			for (int j = 0; j < n; j++) nums[j] = Integer.parseInt(st.nextToken());
			
			long sum = 0;
			
			for (int j = 0; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int A = nums[j];
					int B = nums[k];
					
					sum += getGcd(A, B); 
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		
		System.out.println(sb);
	}
	
	public static int getGcd(int A, int B) {
		if (A % B == 0) return B;
		
		return getGcd(B, A % B);
	}
}
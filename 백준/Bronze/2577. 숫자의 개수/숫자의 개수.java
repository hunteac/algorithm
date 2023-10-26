import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int num = A * B * C;
		
		int[] cnt = new int[10];
		
		while (num > 0) {
			cnt[num % 10]++;
			num /= 10;
		}
		
		for (int n : cnt) {
			System.out.println(n);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] f = new int[N + 1];
		
		f[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) f[i] = (f[i - 1] * 2 + 1) % 10007;
			else f[i] = (f[i - 1] * 2 - 1) % 10007;
		}
		
		System.out.println(f[N]);
	}
}
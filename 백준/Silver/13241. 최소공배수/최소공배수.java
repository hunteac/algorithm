import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		// (두 수의 곱 / 최대공약수) == 최소공배수
		System.out.println(A * B / getGcd(A, B));
	}
	// 두 수의 최대공약수 구하는 메소드
	public static long getGcd(long a, long b) {
		if (b == 0)
			return a;
		else 
			return getGcd(b, a % b);
	}
}
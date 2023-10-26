import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 최대공약수 구하기
	static int getGcd(int i, int j) {
		if (i % j == 0) return j;
		else return getGcd(j, i % j);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int max = Math.max(A, B);
		int min = Math.min(A, B);
		
		int gcd = getGcd(max, min);
		int lcm = 0;
		
		// 최소공배수 구하기
		for (int i = 1; i <= min; i++) {
			if (max * i % min == 0) { 
				lcm = max * i;
				break;
			}
		}
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
}
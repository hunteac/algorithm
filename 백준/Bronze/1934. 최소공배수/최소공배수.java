import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A > B) {
				int plus = B;
				while (true) { 
					B = B + plus;
					if (B % A == 0)
						break;
				}
				System.out.println(B);
			} else if (B > A) {
				int plus = A;
				while (true) {
					A = A + plus;
					if (A % B == 0)
						break;
				}
				System.out.println(A);
			} else {
				System.out.println(A);
			}
		}
	}
}
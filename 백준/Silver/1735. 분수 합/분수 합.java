import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // 첫 번째 분수 분자
		int B = Integer.parseInt(st.nextToken()); // 첫 번째 분수 분모
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // 두 번째 분수 분자
		int D = Integer.parseInt(st.nextToken()); // 두 번째 분수 분모 
		int num = A * D + B * C; // 분자
		int nom = B * D; // 분모
		// 분자와 분모의 최대공약수가 1이면 기약분수 이므로 바로 출력
		if (getGcd(num, nom) == 1) {
			System.out.println(num + " " + nom);
		} else { // 최대공약수가 1이 아니라면 두 수를 최대공약수로 나눈 기약분수 출력
			System.out.println(num / getGcd(num, nom) + " " + nom / getGcd(num, nom));
		}
	}
	// 두 수의 최대공약수를 구하는 메소드
	public static int getGcd(int a, int b) { 
		if (b == 0)
			return a;
		else
			return getGcd(b, a % b);
	}
}
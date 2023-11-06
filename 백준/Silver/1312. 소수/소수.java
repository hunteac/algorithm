import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		double num = A % B;
		
		for (int i = 0; i < N - 1; i++) {
			num *= 10;
			num %= B;
		}
		
		num *= 10;
		
		System.out.println((int) (num / B));
	}
}
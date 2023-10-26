import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int hash = 0;
		
		for (int i = 0; i < N; i++) {
			hash += (s.charAt(i) - 96) * Math.pow(31, i);
		}
		
		System.out.println(hash);
	}
}
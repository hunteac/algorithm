import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			
			if (s.equals("#")) break;
			
			int cnt = 0;
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
						s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A'
						|| s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O'
						|| s.charAt(i) == 'U')
					cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c >= 'a' && c <= 'z') {
				c = (char) ((c + 13 - 'a') % 26 + 'a');
			} else if (c >= 'A' && c <= 'Z') {
				c = (char) ((c + 13 - 'A') % 26 + 'A');
			}
			
			sb.append(c);
		}
		
		System.out.println(sb);
	}
}

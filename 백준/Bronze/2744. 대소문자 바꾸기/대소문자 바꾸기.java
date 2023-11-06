import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String answer = "";
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 97) {
				answer += String.valueOf(s.charAt(i)).toLowerCase();
			} else {
				answer += String.valueOf(s.charAt(i)).toUpperCase(); 
			}
		}
		
		System.out.println(answer);
	}
}
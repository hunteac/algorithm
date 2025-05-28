import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int len = str.length();
		
		String[] strArr = new String[len];
		
		for (int i = 0; i < len; i++) {
			strArr[i] = str.substring(i, len);
		}
		
		Arrays.sort(strArr);
		
		for (int i = 0; i < len; i++) {
			sb.append(strArr[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
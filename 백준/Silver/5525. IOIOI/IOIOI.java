import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		if (N > M / 2) {
			System.out.println(0);
			return;
		}
		
		int cnt = 0;
		int chk = 0;
		
		for (int i = 0; i <= M - 3; i++) {
			if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
				chk++;
				i++;
			} else {
				chk = 0;
			}
			
			if (chk >= N) cnt++;
		}
		
		System.out.println(cnt);
	}
}
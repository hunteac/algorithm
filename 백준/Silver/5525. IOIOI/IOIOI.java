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
		
		for (int i = 0; i <= M - (N * 2 + 1); i++) {
			if (s.charAt(i) == 'O') continue;
			boolean chk = true;
			
			for (int j = i; j < i + (N * 2 + 1); j += 2) {
				if (j != i + N * 2) {
					if (s.charAt(j) != 'I' || s.charAt(j + 1) != 'O') {
						chk = false;
						break;
					}
				} else {
					if (s.charAt(j) != 'I') {
						chk = false;
						break;
					}
				}
			}
			
			if (chk) cnt++;
		}
		
		System.out.println(cnt);
	}
}
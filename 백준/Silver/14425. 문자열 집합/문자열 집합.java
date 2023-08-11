import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static List<String> list1 = new ArrayList<>();
	static List<String> list2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// 한 줄에 입력되는 숫자들을 나눠 받기 위한 StringTokenizer 메소드 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			list1.add(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			list2.add(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			if (list1.contains(list2.get(i)))
				cnt++;
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}
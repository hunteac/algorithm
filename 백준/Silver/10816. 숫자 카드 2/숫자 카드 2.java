import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> cardMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!(cardMap.containsKey(num))) // 맵에 num key값이 없다면
				cardMap.put(num, 1); // 해당 num key 값에 1 할당
			else  // 맵에 num key값이 이미 존재한다면
				cardMap.put(num, cardMap.get(num) + 1); // 해당 key 값에 1 추가
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (cardMap.containsKey(num)) // 해당 숫자 카드를 가지고 있다면
				sb.append(cardMap.get(num)).append(" "); // sb에 개수 추가
			else // 카드를 가지고 있지 않다면
				sb.append(0).append(" "); // sb에 0 추가
		}
		System.out.println(sb);
	}
}
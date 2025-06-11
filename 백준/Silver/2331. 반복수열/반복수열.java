import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Map<Long, Integer> map;
	static Set<Long> set;
	static int idx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		set = new HashSet<>();
		
		dfs(num, cnt, 0);
		
		System.out.println(idx);
	}
	
	public static void dfs(long num, int cnt, int currIdx) {
		if (set.contains(num)) {
			idx = map.get(num);
			return;
		}
		
		set.add(num);
		map.put(num, currIdx);
		
		String sNum = String.valueOf(num);
		long tmp = 0;
		
		for (int i = 0; i < sNum.length(); i++) {
			tmp += Math.pow(sNum.charAt(i) - '0', cnt);
		}
		
		dfs(tmp, cnt, currIdx + 1);
	}
}
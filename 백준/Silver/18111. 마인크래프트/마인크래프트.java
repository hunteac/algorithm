import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] land = new int[N][M]; // 땅
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
				map.put(land[i][j], map.getOrDefault(land[i][j], 0) + 1);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		
		list.addAll(map.keySet());
		Collections.sort(list);
		
		int min = Integer.MAX_VALUE; // 최소 시간
		int max = 0; // 가장 높은 땅 높이
		
		Outer: for (int i = 0; i < 257; i++) {
			int block = B;
			int time = 0;
			
			for (int j = list.size() - 1; j >= 0; j--) {
				int h = list.get(j);
				
				if (h == i) continue;
				
				if (h > i) {
					time += (h - i) * 2 * map.get(h);
					block += (h - i) * map.get(h);
				} else {
					if (block < (i - h) * map.get(h)) continue Outer;
					time += (i - h) * map.get(h);
					block -= (i - h) * map.get(h);
				}
			}
			
			min = Math.min(min, time);
			
			if (time == min) max = Math.max(max, i);
		}
		
		System.out.println(min + " " + max);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Set<Integer> set = new HashSet<>();
		
		int M = Integer.parseInt(br.readLine());
		int num = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
				case "add":
					num = Integer.parseInt(st.nextToken());
					set.add(num);
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					if (set.contains(num)) set.remove(num);
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					if (set.contains(num)) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					if (set.contains(num)) set.remove(num); 
					else set.add(num);
					break;
				case "all":
					for (int j = 1; j <= 20; j++) {
						if (set.contains(j)) continue;
						set.add(j);
					}
					break;
				case "empty":
					set.clear();
					break;
			}
		}
		
		System.out.println(sb);
	}
}
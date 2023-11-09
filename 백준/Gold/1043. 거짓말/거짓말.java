import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		if (T == 0) {
			System.out.println(M);
			return;
		} else {
			Set<Integer> truth = new HashSet<>(); // 진실을 아는 사람들
			List<Integer>[] parties = new ArrayList[M]; // 파티에 참여하는 사람들
			
			for (int i = 0; i < T; i++) truth.add(Integer.parseInt(st.nextToken()));
			for (int i = 0; i < M; i++) parties[i] = new ArrayList<>();
			
			int cnt = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
					
				int len = Integer.parseInt(st.nextToken());
				boolean chk = false;
					
				for (int j = 0; j < len; j++) {
					parties[i].add(Integer.parseInt(st.nextToken()));
					if (truth.contains(parties[i].get(j))) chk = true;
				}
					
				for (int j = 0; j < len; j++) {
					if (chk) truth.add(parties[i].get(j)); 
				}
			}
			
			for (int t = 0; t < M; t++) {
				for (int i = 0; i < M; i++) {
					boolean chk = true;
					for (int j = 0; j < parties[i].size(); j++) {
						if (truth.contains(parties[i].get(j))) {
							chk = false;
							break;
						}
					}
					if (!chk) {
						for (int j = 0; j < parties[i].size(); j++) {
							truth.add(parties[i].get(j));
						}
					}
				}
			}
			
			for (int i = 0; i < M; i++) {
				boolean chk = true;
				for (int j = 0; j < parties[i].size(); j++) {
					if (truth.contains(parties[i].get(j))) {
						chk = false;
						break;
					}
				}
				if (chk) cnt++;
			}
			
			System.out.println(cnt);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> set = new HashSet<>(); // 중복 제거를 위한 셋 
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited; // 방문 체크
	static int[] nums; // 숫자 배열
	static int[] p; // 수열 배열
	static int N; // N개 자연수
	static int M; // M개 수열
	
	// 순열 알고리즘
	static void permutation(int idx) {
		if (idx == M) {
			sb = new StringBuilder();
			
			for (int i = 0; i < M; i++) sb.append(p[i]).append(" ");
				
			if (set.contains(sb.toString())) return; // 중복 수열이면 종료
			
			set.add(sb.toString()); // 수열 담기
			
			for (int i = 0; i < M; i++) System.out.print(p[i] + " "); // 수열 출력
			System.out.println();
			
			return; // 종료
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue; // 선택한 원소면 continue
			visited[i] = true; // 원소 선택
			p[idx] = nums[i];
			permutation(idx + 1); // 다음 원소
			visited[i] = false; // 원소 선택 X
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        
        visited = new boolean[N];
        nums = new int[N];
        p = new int[M];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums); // 오름차순 정렬
        
        permutation(0); // 순열 알고리즘
    }
}
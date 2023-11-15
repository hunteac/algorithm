import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 나무 길이
		
		int[] tree = new int[N]; // 나무 배열
		
		st = new StringTokenizer(br.readLine());
		int max = 0; // 최대 나무 높이
		
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]); // 최대 나무 높이 구하기
		}
		
		int start = 0; // 시작
		int end = max; // 끝
		int mid = 0; // 중앙
		long tmpsum = 0;
		long sum = 0;
		
		// 이분탐색
		while (start <= end) {
			mid = (start + end) / 2;
			sum = 0;
			tmpsum = 0;
			
			for (int i = 0; i < N; i++) {
				if (tree[i] <= mid) continue;
				
				sum += tree[i] - mid;
				tmpsum += tree[i] - mid - 1;
			}
			
			if (sum >= M && tmpsum < M) break; // 현재 높이가 길이를 얻을 수 있는 최대 높이라면
			
			if (sum < M) end = mid - 1; // 길이가 모자라면 높이 줄이기
			else if (sum > M) start = mid + 1; // 길이가 남으면 높이 늘리기
			else break; // 길이가 맞으면 종료
		}
		
		System.out.println(mid);
	}
}
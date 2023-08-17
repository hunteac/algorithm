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
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<Integer> set1 = new HashSet<>(); // A 집합
		Set<Integer> set2 = new HashSet<>(); // B 집합
		Set<Integer> set3 = new HashSet<>(); // 임시 집합
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			set1.add(Integer.parseInt(st.nextToken())); 
		}
		set3.addAll(set1); // 임시 집합에 A 집합 원소 더하기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			set2.add(Integer.parseInt(st.nextToken()));
		}
		// A - B 차집합 원소 구하기
		set1.removeAll(set2);
		// B - A 차집합 원소 구하기
		set2.removeAll(set3);
		// 대칭 차집합 원소 개수 출력
		System.out.println(set1.size() + set2.size());
	}
}
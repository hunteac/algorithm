import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		// set을 사용해 중복 값 제거
		Set<Integer> set = new HashSet<>(list);
		List<Integer> tmplist = new ArrayList<>(set);
		// 리스트 오름차순 정렬
		Collections.sort(tmplist);
		// idx와 해당 idx의 값들을 담기 위한 맵 선언
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < tmplist.size(); i++) {
			map.put(tmplist.get(i), i);
		}
		// map이 list 원소를 포함하고 있다면 해당 원소 key의 value값 sb에 추가
		for (int i = 0; i < list.size(); i++) {
			if (map.containsKey(list.get(i)))
				sb.append(map.get(list.get(i))).append(" ");
		}
		System.out.println(sb);
	}
}
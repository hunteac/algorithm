import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hMap = new HashMap<>(); // 단어 등장 횟수 측정 맵
        List<String> words = new ArrayList<>(); // 단어장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) continue;
            hMap.put(s, hMap.getOrDefault(s, 0) + 1);
        }
        for (String s : hMap.keySet()) {
            words.add(s);
        }
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hMap.get(o1) != hMap.get(o2)) return hMap.get(o2) - hMap.get(o1); // 등장 횟수 정렬 
                if (o1.length() != o2.length()) return o2.length() - o1.length(); // 길이 순 정렬
                return o1.compareTo(o2); // 사전 순 정렬
            }
        });
        for (String s : words) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hMap = new HashMap<>(); // 단어 등장 횟수 측정 맵
        HashSet<String> chk = new HashSet<>(); // 중복 제거 셋
        String[] words = new String[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() >= M) words[i] = s;
            else words[i] = "";
        }
        Arrays.sort(words); // 사전순 정렬
        Arrays.sort(words, ((o1, o2) -> (o2.length() - o1.length()))); // 길이순 역정렬
        for (int i = 0; i < N; i++) {
            if (words[i].isEmpty()) continue;
            hMap.put(words[i], hMap.getOrDefault(words[i], 0) + 1);
            max = Math.max(max, hMap.get(words[i])); // 최대 단어 등장 횟수
        }
        for (int i = max; i >= 1; i--) {
            if (!hMap.containsValue(i)) continue;
            for (int j = 0; j < words.length; j++) {
                if (words[j].isEmpty()) continue;
                if (hMap.get(words[j]) == i)
                    if (chk.add(words[j])) sb.append(words[j]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
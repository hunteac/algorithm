import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map1 = new HashMap<>(); // mbti별 등장 횟수
            HashMap<Integer, String> map2 = new HashMap<>(); // mbti별 인덱스

            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = 0;

            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();
                map1.put(mbti, !map1.containsKey(mbti) ? 1 : map1.get(mbti) + 1); // 등장 횟수 구하기
                if (!map2.containsValue(mbti)) map2.put(idx++, mbti);
            }

            int min = Integer.MAX_VALUE; // 최소 거리

            if (map1.size() == 1) { // 모두 같은 경우
                min = 0;
            } else if (map1.size() == 2) { // 한 명만 다른 경우
                String A = map2.get(0);
                String B = map2.get(1);
                min = 0;

                for (int i = 0; i < 4; i++) if (A.charAt(i) != B.charAt(i)) min += 2;
            } else { // 완전 탐색
                for (int i = 0; i < map2.size(); i++) {
                    for (int j = 0; j < map2.size(); j++) {
                        for (int k = 0; k < map2.size(); k++) {
                            String A = map2.get(i);
                            String B = map2.get(j);
                            String C = map2.get(k);

                            if (i == j && j == k && map1.get(A) < 3) continue;
                            if ((i == j && map1.get(A) < 2) || (j == k && map1.get(B) < 2) || (i == k && map1.get(A) < 2)) continue;

                            int dist = 0;

                            for (int l = 0; l < 4; l++) {
                                if (A.charAt(l) != B.charAt(l)) dist++;
                                if (B.charAt(l) != C.charAt(l)) dist++;
                                if (A.charAt(l) != C.charAt(l)) dist++;
                            }

                            min = Math.min(min, dist);
                        }
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
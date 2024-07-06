import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> ringNum = new HashMap<>(); // 반지별 수
        ArrayList<String> ringType = new ArrayList<>(); // 커플 의심군 반지 특징
        String[][] names = new String[N][2]; // [][0] : 이름, [][1] : 반지 특징

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();

            names[i][0] = name;
            names[i][1] = ring;

            if (ring.equals("-")) continue;

            ringNum.put(ring, ringNum.getOrDefault(ring, 0) + 1);
            if (ringNum.get(ring) == 2) {
                ringType.add(ring);
            } else if (ringNum.get(ring) > 2) {
                ringType.remove(ring);
            }
        }

        for (String ring : ringType) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (ring.equals(names[i][1])) {
                    sb.append(names[i][0]);
                    if (cnt == 0) sb.append(" ");
                    cnt++;
                }
                if (cnt == 2) break;
            }
            sb.append("\n");
        }

        System.out.println(ringType.size());
        if (!ringType.isEmpty()) System.out.println(sb);
    }
}
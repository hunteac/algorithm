import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> works = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()); // 걸리는 시간
            int t = Integer.parseInt(st.nextToken()); // 마감일

            works.put(t, works.getOrDefault(t, 0) + d);
            set.add(t);
        }

        ArrayList<Integer> times = new ArrayList<>(set);

        Collections.sort(times); // 오름차순 정렬

        int len = times.size();
        int day = times.get(len - 1) - works.get(times.get(len - 1)); // 마지막 과제 시작일

        for (int i = len - 2; i >= 0; i--) { // 역순
            int nextT = times.get(i); // 이전 과제 마감 시간
            int nextD = works.get(nextT); // 이전 과제 걸리는 시간
            if (day < nextT) { // 과제를 하는 기간이 중복되는 경우
                day -= nextD; // 그대로 차감
                continue;
            }

            day = nextT - nextD; // 현재 날짜 갱신
        }

        int max = day; // 1일부터 연속으로 놀 수 있는 최대 기간

        System.out.println(max);
    }
}

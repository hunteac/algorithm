import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 건물 개수
            int m = Integer.parseInt(st.nextToken()); // 관계 개수

            ArrayList<Integer>[] lists = new ArrayList[n + 1];
            ArrayList<Integer>[] tmp = new ArrayList[n + 1];

            int[] nums = new int[n + 1]; // 선행 건물 개수
            int[] time = new int[n + 1]; // 건물별 건설 시간

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                lists[i] = new ArrayList<>();
                tmp[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 선행 건물
                int Y = Integer.parseInt(st.nextToken()); // 다음 건물

                tmp[Y].add(X);
                lists[X].add(Y);

                nums[Y]++;
            }

            int target = Integer.parseInt(br.readLine()); // 목표 건물 번호
            int min = 0; // 건설완료 최소시간

            Queue<Integer> queue = new LinkedList<>();
            HashSet<Integer> set = new HashSet<>();

            queue.add(target);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                set.add(curr);

                for (int i = 0; i < tmp[curr].size(); i++) {
                    int next = tmp[curr].get(i);
                    if (!set.contains(next)) {
                        queue.add(next);
                    }
                }
            }

            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                if (nums[i] == 0 && set.contains(i)) { // 선행 건물이 없는 건물들 큐에 넣기
                    queue.add(i);
                    dp[i] = time[i];
                }
            }

            int max = -1; // 최대 시간

            Outer: while (!queue.isEmpty()) {
                int len = queue.size(); // 순서

                for (int i = 0; i < len; i++) {
                    int curr = queue.poll();

                    if (curr == target) break Outer; // 건설 완료

                    for (int j = 0; j < lists[curr].size(); j++) {
                        int next = lists[curr].get(j); // 선행 건물 번호
                        if (--nums[next] == 0 && set.contains(next)) queue.add(next); // 건설 시작
                        dp[next] = Math.max(dp[next], dp[curr] + time[next]); // 동적계획법 최대 시간 갱신
                    }
                }
            }
            
            sb.append(dp[target]).append("\n");
        }
        
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int curr;
        int cnt;

        Pos (int curr, int cnt) {
            this.curr = curr;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ladders = new int[100]; // 사다리 정보
        int[] snakes = new int[100]; // 뱀 정보

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ladders[start] = end;
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            snakes[start] = end;
        }

        Queue<Pos> queue = new LinkedList<>();
        int[] minCnt = new int[101]; // 칸별 최소 이동 횟수

        Arrays.fill(minCnt, Integer.MAX_VALUE);

        queue.add(new Pos(1, 0));
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Pos p = queue.poll();

            int curr = p.curr; // 현재 칸
            int cnt = p.cnt; // 현재 이동 횟수

            if (cnt >= min) continue;

//            System.out.println("curr : " + curr + " cnt : " + cnt);

            if (curr == 100) { // 도착
                min = Math.min(min, cnt);
                continue;
            } else if (curr > 100) { // 범위를 벗어나면 continue
                continue;
            }

            for (int idx = 1; idx <= 6; idx++) {
                int next = curr + idx;
                if (next < 100 && ladders[next] != 0) next = ladders[next]; // 사다리 이용
                if (next < 100 && snakes[next] != 0) next = snakes[next]; // 뱀 이용
                if ((next < 100 && minCnt[next] <= cnt + 1) || next > 100) continue;

                minCnt[next] = cnt + 1;

                queue.add(new Pos(next, cnt + 1));
            }
        }

        System.out.println(min);
    }
}
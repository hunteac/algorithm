import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos { // 도로, 웜홀 정보
        int from; // 이전 지점 번호
        int to; // 다음 지점 번호
        int time; // 이동 시간

        Pos (int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            ArrayList<Pos> lists = new ArrayList<>();

            for (int i = 0; i < M + W; i++) { // 도로
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken()); // 시작
                int E = Integer.parseInt(st.nextToken()); // 도착
                int T = Integer.parseInt(st.nextToken()); // 시간

                if (i >= M) { // 웜홀
                    lists.add(new Pos(S, E, -T));
                } else { // 도로
                    lists.add(new Pos(S, E, T));
                    lists.add(new Pos(E, S, T));
                }
            }

            int[] times = new int[N + 1]; // 현재 시간 정보
            boolean chk = false; // 가능 여부

            for (int start = 1; start <= N; start++) {
                for (Pos curr : lists) {
                    int time = times[curr.from] + curr.time;
                    if (times[curr.to] > time) {
                        times[curr.to] = time;

                        if (start == N) { // 음수 사이클 존재
                            chk = true;
                        }
                    }
                }
            }

            if (chk) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
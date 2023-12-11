import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int curr; // 현재 위치
        int time; // 현재 시간

        Pos(int curr, int time) {
            this.curr = curr;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        boolean[] visited = new boolean[100001];
        int[] count = new int[100001];

        Queue<Pos> queue = new LinkedList<>();

        queue.add(new Pos(N, 0));
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            int curr = p.curr; // 현재 위치
            int time = p.time; // 현재 시간

            if (curr == K) min = Math.min(min, time); // 동생을 발견하면 최솟값 갱신

            if (time > min || curr < 0 || curr > 100000) continue; // 범위를 벗어나거나 최소 시간보다 크면 continue
            if (visited[curr] && count[curr] < time) continue; // 방문했고 현재 시간보다 방문했던 시간이 작으면 continue
            visited[curr] = true; // 방문 처리
            count[curr] = time; // 시간 갱신

            if (curr == 0) queue.add(new Pos(curr + 1, time + 1));
            else {
                queue.add(new Pos(curr + 1, time + 1));
                queue.add(new Pos(curr - 1, time + 1));
                queue.add(new Pos(curr * 2, time));
            }
        }

        System.out.println(min);
    }
}
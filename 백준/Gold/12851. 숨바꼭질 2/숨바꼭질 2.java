import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static Queue<Pos> queue; // 위치를 담는 큐
    static boolean[] visited; // 방문 체크
    static int[] count; // 위치별 이동 횟수 체크
    static int N; // 출발 지점
    static int K; // 도착 지점
    static int min; // 최소 횟수
    static int num; // 최소 횟수 개수

    static void bfs() {
        queue.add(new Pos(N, 0)); // 출발 지점 담기

        while (!queue.isEmpty()) {
            Pos p = queue.poll();

            int curr = p.curr; // 현재 위치
            int cnt = p.cnt; // 현재 이동 횟수

            if (curr < 0 || curr > 100000) continue; // 범위를 벗어나면 continue

//            System.out.println("curr : " + curr + " cnt : " + cnt + " num : " + num + " count : " + count[curr]);

            if (curr == K && cnt <= min) { // 동생 발견
                min = cnt; // 최소 횟수 갱신
                num++; // 개수 추가
            }

            if ((visited[curr] && count[curr] < cnt) || cnt >= min) continue; // 동일한 장소에 가거나 최소 횟수 보다 크면 continue
            visited[curr] = true; // 방문 처리
            count[curr] = cnt; // 위치 이동 횟수 체크

            queue.add(new Pos(curr + 1, cnt + 1)); // 앞으로 걷기
            queue.add(new Pos(curr - 1, cnt + 1)); // 뒤로 걷기
            if (curr != 0) queue.add(new Pos(curr * 2, cnt + 1)); // 뒤로 걷기
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        queue = new LinkedList<>();
        visited = new boolean[100001];
        count = new int[100001];

        bfs();

        System.out.println(min);
        System.out.println(num);
    }
}
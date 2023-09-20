import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 현재 위치 객체 생성 클래스
    static class Pos {
        int pos;
        int time;
        Pos(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    static Queue<Pos> queue = new LinkedList<>();
    static boolean[] visited; // 방문 체크
    static int N; // 수빈 위치
    static int K; // 동생 위치

    static int BFS(int n, int t) {
        queue.add(new Pos(n, t));

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            int p = pos.pos;
            if (p >= 0 && p <= 100000) {
                int time = pos.time;
                if (p == K) return time;

                if (visited[p]) continue;
                visited[p] = true;
                queue.add(new Pos(p - 1, time + 1)); // -1 이동
                queue.add(new Pos(p + 1, time + 1)); // +1 이동
                queue.add(new Pos(p * 2, time + 1)); // *2 이동
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[100001];
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(BFS(N, 0));
    }
}
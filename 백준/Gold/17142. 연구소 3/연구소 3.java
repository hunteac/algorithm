import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Virus { // 바이러스 객체 생성 클래스
        int r;
        int c;
        Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Virus> queue; // 바이러스 객체를 담을 큐
    static boolean[][] visited; // 방문 체크
    static int[][] lab; // 연구소
    static int[][] tmplab; // 연구소 복원
    static int[][] pos; // 바이러스 활성화 위치
    static int[][] comb; // 조합
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 연구소 크기
    static int M; // 활성화 바이러스 수
    static int min; // 최소 시간
    static int cnt; // 빈 공간 개수
    static int time; // 각 케이스별 시간

    // 깊이 우선 탐색 메소드
    static int BFS (int num) {
        time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            if (num == 0) {
                queue.clear();
                return time;
            }

            for (int i = 0; i < size; i++) {
                Virus v = queue.poll();
                int cr = v.r; // 현재 바이러스 행 좌표
                int cc = v.c; // 현재 바이러스 열 좌표

                for (int d = 0; d < 4; d++) {
                    int rr = cr + dr[d]; // 다음 행 좌표
                    int rc = cc + dc[d]; // 다음 열 좌표
                    if (rr < 0 || rc < 0 || rr >= N || rc >= N || visited[rr][rc] || lab[rr][rc] == 1)
                        continue;
                    visited[rr][rc] = true; // 방문처리

                    if (lab[rr][rc] == 0) { // 빈 공간 바이러스 활성화
                        lab[rr][rc] = 2;
                        num--;
                    }

                    queue.add(new Virus(rr, rc));
                }
            }
        }
        return min;
    }

    // 조합 메소드
    static void combination(int idx1, int idx2) {
        // 기저
        if (idx1 == M) { // 활성 바이러스 조합 완성
            for (int i = 0; i < N; i++) { // 연구소 상태 초기화
                for (int j = 0; j < N; j++) {
                    lab[i][j] = tmplab[i][j];
                }
            }
            int num = cnt;
            visited = new boolean[N][N]; // 방문 체크 초기화
            for (int i = 0; i < comb.length; i++) { // 활성 바이러스 위치 큐에 넣기
                queue.add(new Virus(comb[i][0], comb[i][1]));
            }
            min = Math.min(min, BFS(num)); // 최소 시간 구하기
            return;
        }
        if (idx2 == pos.length) return;
        // 재귀
        comb[idx1][0] = pos[idx2][0];
        comb[idx1][1] = pos[idx2][1];
        combination(idx1 + 1, idx2 + 1);
        combination(idx1, idx2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        queue = new LinkedList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        tmplab = new int[N][N];
        lab = new int[N][N];

        int len = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = tmplab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) cnt++;
                if (lab[i][j] == 2) len++;
            }
        }

        pos = new int[len][2];
        comb = new int[M][2];
        len = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == 2) {
                    pos[len][0] = i;
                    pos[len][1] = j;
                    len++;
                }
            }
        }

        combination(0, 0);

        if (min == Integer.MAX_VALUE) System.out.println(-1); // 활성화가 불가능한 경우 -1 출력
        else System.out.println(min);
    }
}
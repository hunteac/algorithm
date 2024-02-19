import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 행
    static int M; // 열
    static int D; //  공격 거리 제한
    static int[][] map; // 격자판
    static int[] comb; // 궁수 위치를 담고 있는 배열
    static int max; // 제거할 수 있는 최대 수
    // 궁수 위치를 정하는 조합 알고리즘
    static void combination (int num, int idx) {
        if (idx == 3) {
            boolean[][] chk = new boolean[N][M];
            int[][] days = new int[N][M];
            int cnt = 0; // 제거한 적 수
            int day = N; // 날짜
            for (int t = day; t >= 1; t--) {
                int kill = 0; // 하루에 제거한 적 수
                for (int x : comb) { // 궁수 x좌표
                    Outer: for (int d = 1; d <= D; d++) { // 가까운 거리부터 탐색
                        for (int c = x - d + 1; c <= x + d - 1; c++) { // 왼쪽부터 탐색
                            if (c < 0 || c >= M) continue;
                            for (int r = t - 1; r >= t - d; r--) {
                                if (r < 0) break;
                                int dist = Math.abs(t - r) + Math.abs(x - c); // 거리
                                if (!chk[r][c] && map[r][c] == 1 && dist == d) { // 다른 적을 죽인 경우
                                    chk[r][c] = true;
                                    days[r][c] = t;
                                    kill++;
                                    break Outer;
                                } else if (days[r][c] == t && chk[r][c] && map[r][c] == 1 && dist == d) { // 같은 적을 죽인 경우
                                    break Outer;
                                }
                            }
                        }
                    }
                }
                cnt += kill;
            }
            max = Math.max(max, cnt); // 최대 제거 수 갱신

            return; // 종료
        }

        if (num >= M) return; // 종료

        comb[idx] = num;
        combination(num + 1, idx + 1);
        combination(num + 1, idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        comb = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        System.out.println(max);
    }
}
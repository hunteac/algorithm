import java.util.*;

class Solution {
    static int[][][] hole; // 웜홀
    static int[][] board; // 게임판
    static int[][] crash; // 충돌 횟수
    static int[][] blocks = {{}, { 2, 3, 1, 0 }, { 1, 3, 0, 2 }, { 3, 2, 0, 1 }, { 2, 0, 3, 1 }, { 2, 3, 0, 1 }}; // 벽돌들
    static int[] dr = { -1, 0, 1, 0 }; // 상(0), 우(1), 하(2), 좌(3)
    static int[] dc = { 0, 1, 0, -1 };
    static int N; // 크기
    static int max; // 점수 최댓값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();

            max = 0;

            board = new int[N][N];
            crash = new int[N][N];
            hole = new int[11][2][2];
            boolean[][] chk = new boolean[11][2];


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                    if (board[i][j] >= 6) {
                        int idx = 0;
                        if (chk[board[i][j]][idx]) idx = 1;
                        chk[board[i][j]][idx] = true;
                        hole[board[i][j]][idx][0] = i;
                        hole[board[i][j]][idx][1] = j;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) { // 출발 가능
                        for (int k = 0; k < 4; k++) { // 방향 정하기
                            int startR = i; // 출발 행 좌표
                            int startC = j; // 출발 열 좌표
                            int r = i; // 현재 행 좌표
                            int c = j; // 현재 열 좌표
                            int d = k; // 방향
                            int cnt = 0;
                            int score = 0; // 점수
                            while (true) {
                                // 출발 지점 혹은 블랙홀 도착시 종료
                                if (cnt > 0 && r >= 0 && c >= 0 && r < N && c < N && ((r == startR && c == startC) || board[r][c] == -1)) {
                                    max = Math.max(max, score);
                                    break;
                                }

                                if (r < 0 || c < 0 || r >= N || c >= N) { // 공이 벽에 부딪히는 경우
                                    score++;
                                    d = (d + 2) % 4; // 방향 전환
                                    if (r < 0) r = 0;
                                    if (c < 0) c = 0;
                                    if (r >= N) r = N - 1;
                                    if (c >= N) c = N - 1;
                                    crash[r][c]++;
                                    if (crash[r][c] >= N * N) break;
                                    if (r == startR && c == startC && board[r + dr[d]][c + dc[d]] != -1) break;
                                }

                                if (board[r][c] >= 1 && board[r][c] <= 5) { // 공이 블록에 부딪히는 경우
                                    score++;
                                    crash[r][c]++;
                                    if (crash[r][c] >= N * N) break;
                                    d = blocks[board[r][c]][d];
                                }

                                if (board[r][c] >= 6) { // 웜홀을 만나는 경우
                                    int tmpr = r;
                                    int tmpc = c;
                                    if (hole[board[r][c]][0][1] == c && hole[board[r][c]][0][0] == r) {
                                        r = hole[board[tmpr][tmpc]][1][0];
                                        c = hole[board[tmpr][tmpc]][1][1];
                                    } else {
                                        r = hole[board[tmpr][tmpc]][0][0];
                                        c = hole[board[tmpr][tmpc]][0][1];
                                    }
                                }

                                r = r + dr[d]; // 다음 행 좌표
                                c = c + dc[d]; // 다음 열 좌표

                                cnt++;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
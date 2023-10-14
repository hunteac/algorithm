import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board; // 점수 판
    static boolean[] chk; // 상대 팀
    static int[] comb; // 조합
    static int N; // 크기
    static int min; // 최소 차이

    // 조합 알고리즘으로 팀 고르기
    static void combination(int idx, int pick) {
        if (idx == N / 2) {
            chk = new boolean[N];
            int start = 0; // 스타트 팀
            int link = 0; // 링크 팀

            for (int i = 0; i < comb.length - 1; i++) { // 조합으로 구한 스타트 팀 점수 구하기
                chk[comb[i]] = true;
                for (int j = i + 1; j < comb.length; j++) {
                    chk [comb[j]] = true;
                    start += board[comb[i]][comb[j]] + board[comb[j]][comb[i]];
                }
            }

            for (int i = 0; i < N - 1; i++) { // 링크 팀 점수 구하기
                for (int j = i + 1; j < N; j++) {
                    if (!chk[i] && !chk[j]) link += board[i][j] + board[j][i];
                }
            }

            min = Math.min(min, Math.abs(start - link)); // 점수 최소 차이 구하기

            return; // 종료
        }

        if (pick == N) return;
        if (comb[0] != 0) return; // 백트래킹

        comb[idx] = pick; // 선수 고르기
        combination(idx + 1, pick + 1);
        combination(idx, pick + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;

        board = new int[N][N];
        comb = new int[N / 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        System.out.println(min);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int cnt; // 퀸을 놓을 수 있는 경우의 수
    static int[][] map; // 체스판
    static int[] queen; // 퀸

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        queen = new int[N];
        recur(0);
        System.out.println(cnt);
    }
    // 행을 기준으로 탐색하는 재귀 메소드
    public static void recur(int row) {
        if (row == N) {
            cnt++; // 경우의 수 1증가
            return;
        }
        for (int c = 0; c < N; c++) { // 열 탐색
            if (!check(row, c)) continue; // 퀸을 놓을 수 없으면 continue
            queen[row] = c;
            recur(row + 1);
        }
    }
    public static boolean check(int row, int col) {
        for (int r = 0; r < row; r++) {
            if (queen[r] == col) return false; // 각 행의 열 체크
            if (Math.abs(row - r) == Math.abs(col - queen[r])) return false; // 대각선 체크
        }
        return true; // 퀸을 놓을 수 있다.
    }
}
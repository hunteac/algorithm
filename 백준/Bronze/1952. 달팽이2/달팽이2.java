import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] map = new int[M][N];
        int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 이동
        int[] dc = { 1, 0, -1, 0 };

        int r = 0; // 행
        int c = 0; // 열
        int d = 0;
        int cnt = 0; // 방향 전환 횟수
        int num = 1;
        map[0][0] = num++;

        while (num <= M * N) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] != 0) { // 방향 전환
                d = (d + 1) % 4;
                cnt++; // 횟수 증가
            }

            r += dr[d];
            c += dc[d];

            map[r][c] = num++;
        }

        System.out.println(cnt);
    }
}
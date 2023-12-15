import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r;
        int c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static boolean[][] air; // 공기가 통하는 공간
    static int[][] cheeze; // 치즈
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 세로 크기
    static int M; // 가로 크기

    static void check(int r, int c) {
        if (air[r][c]) return;
        air[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d]; // 다음 행
            int nc = c + dc[d]; // 다음 열
            // 범위를 벗어나거나 이미 공기가 통하면 continue
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || air[nr][nc] || cheeze[nr][nc] == 1) continue;

            check(nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        int time = 0; // 치즈가 모두 녹는데 걸리는 시간
        int piece = 0; // 치즈 조각 수


        cheeze = new int[N][M]; // 치즈

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
                if (cheeze[i][j] == 1) piece++;
            }
        }

        Queue<Pos> queue = new LinkedList<>();
        int left = 0; // 모두 녹기 전 남은 치즈 조각 수

        while (true) {
            ArrayList<Integer[]> list = new ArrayList<>();
            air = new boolean[N][M]; // 공기가 통하는 공간
            check(0, 0); // 체크
            left = piece;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (cheeze[r][c] == 1) { // 치즈 조각인 경우만 확인
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (air[nr][nc]) { // 공기중에 치즈가 노출되면 조각 -1
                                list.add(new Integer[] {r, c});
                                piece--;
                                break;
                            }
                        }
                    }
                }
            }

            // 치즈 조각 없애기
            for (int i = 0; i < list.size(); i++) {
                int r = list.get(i)[0];
                int c = list.get(i)[1];
                cheeze[r][c] = 0;
            }

            time++; // 시간 +1
            if (piece == 0) break; // 치즈가 모두 녹으면 종료
        }

        System.out.println(time);
        System.out.println(left);
    }
}
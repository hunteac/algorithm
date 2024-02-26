import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map; // 종이
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 세로 크기
    static int M; // 가로 크기
    static int max; // 최댓값

    // 깊이 우선 탐색을 활용한 테트로미노 만들기
    static void dfs(int r, int c, int cnt, int score, List<Integer[]> check) {
        if (cnt == 1) { // 블록 두개 선택
            for (int di = 0; di < 3; di++) {
                for (int dj = di + 1; dj < 4; dj++){
                    int fnr = r + dr[di]; // 첫번째 블록
                    int fnc = c + dc[di];
                    int snr = r + dr[dj]; // 두번째 블록
                    int snc = c + dc[dj];
                    // 범위를 벗어나면 continue
                    if (fnr < 0 || fnr >= N || fnc < 0 || fnc >= M || snr < 0 || snr >= N || snc < 0 || snc >= M) continue;

                    check.add(new Integer[]{r, c});
                    check.add(new Integer[]{fnr, fnc});
                    check.add(new Integer[]{snr, snc});

                    dfs(fnr, fnc, 3, score + map[fnr][fnc] + map[snr][snc], check);
                    dfs(snr, snc, 3, score + map[fnr][fnc] + map[snr][snc], check);
                    dfs(r, c, 3, score + map[fnr][fnc] + map[snr][snc], check);
                }
            }
        } else if (cnt == 3) { // 나머지 블록 선택
            Outer: for (int d = 0; d < 4; d++) {
                int nr = r + dr[d]; // 다음 행
                int nc = c + dc[d]; // 다음 열
                // 범위를 벗어나거나 이미 선택한 블록은 continue
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                for (int i = check.size() - 3; i < check.size(); i++) {
                    if (check.get(i)[0] == nr && check.get(i)[1] == nc) continue Outer;
                }

                // 테트로미노 완성시 최댓값 갱신
                if (score + map[nr][nc] > max) {
                    max = Math.max(max, score + map[nr][nc]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer[]> check = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 1, map[i][j], check); // 너비 우선 탐색
            }
        }

        System.out.println(max);
    }
}
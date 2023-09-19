import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[][] field; // 배추밭
    public static int M; // 가로 크기
    public static int N; // 세로 크기
    public static int cnt; // 배추흰지렁이 수

    // DFS (깊이 우선 탐색) 메소드
    public static void DFS(int i, int j) {
        if (i >= 0 && j >= 0 && i < N && j < M) { // 배추밭 범위 내에서만 확인
            if (!field[i][j]) return; // 배추가 없으면 return
            field[i][j] = false; // 방문 한 곳 지우기
            DFS(i - 1, j); // 상
            DFS(i, j + 1); // 우
            DFS(i + 1, j); // 하
            DFS(i, j - 1); // 좌 확인
        } else return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            field = new boolean[N][M];
            cnt = 0;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j]) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
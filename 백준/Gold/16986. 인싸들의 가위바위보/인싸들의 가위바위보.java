import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] info; // 상관관계
    static int[] B; // 경희
    static int[] C; // 민호
    static boolean[] visited; // 방문 체크
    static boolean chk; // 가능 여부
    static int N, K;
    // 깊이 우선 탐색을 이용한 완전 탐색
    // order == "A" : 지우 vs 경희
    // order == "B" : 지우 vs 민호
    // order == "C" : 경희 vs 민호
    static void game(int bCurr, int cCurr, int cnt, int b, int c, String order) {
        if (bCurr >= 20 || cCurr >= 20 || b == K || c == K || chk) return; // 불가능
        if (cnt == K) { // 가능
            chk = true;
            return;
        }

        if (order.equals("C")) {
            if (info[B[bCurr]][C[cCurr]] == 2) game(bCurr + 1, cCurr + 1, cnt, b + 1, c, "A"); // 경희 승
            else game(bCurr + 1, cCurr + 1, cnt, b, c + 1, "B"); // 민호 승
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true; // 선택

            if (order.equals("A")) {
                if (info[i][B[bCurr]] == 2) { // 승
                    game(bCurr + 1, cCurr, cnt + 1, b, c, "B");
                } else { // 패
                    game(bCurr + 1, cCurr, cnt, b + 1, c, "C");
                }
            } else {
                if (info[i][C[cCurr]] == 2) { // 승
                    game(bCurr, cCurr + 1, cnt + 1, b, c, "A");
                } else { // 패
                    game(bCurr, cCurr + 1, cnt, b, c + 1, "C");
                }
            }

            visited[i] = false; // 취소 (백트래킹)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 손동작 수
        K = Integer.parseInt(st.nextToken()); // 승수

        info = new int[N + 1][N + 1];
        B = new int[20];
        C = new int[20];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) B[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) C[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        game(0, 0, 0, 0, 0, "A");

        if (chk) System.out.println(1); // 가능
        else System.out.println(0); // 불가능
    }
}
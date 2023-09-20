import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        int M = Integer.parseInt(st.nextToken()); // 연결된 지사 컴퓨터

        int[][] adjArr = new int[N][N]; // 인접 행렬
        p = new int[N + 1]; // 대표자(연결 여부)

        for (int i = 0; i < N + 1; i++) {
            p[i] = i;
        }

        int set = N - 1; // 지사 컴퓨터 집합 수

        // 지사 컴퓨터 연결하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (union(A, B)) set--;
        }

        // 안전한 네트워크
        if (set == 1) {
            System.out.println(0 + " " + 0);
            return;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] edges = new int[N * N][3];

        int idx = 0;
        for (int i = 2; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                if (find(i) != find(j)) {
                    edges[idx][0] = i;
                    edges[idx][1] = j;
                    edges[idx][2] = adjArr[i - 1][j - 1];
                    idx++;
                }
            }
        }

        // 오름차순 정렬
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int X = 0; // 최소 비용
        int K = 0; // 연결 횟수

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if (find(x) != find(y)) {
                union(x, y);
                X += edges[i][2];
                K++;
                set--;
                sb.append(x).append(" ");
                sb.append(y).append("\n");
            }
            if (set == 1) break;
        }

        System.out.println(X + " " + K);
        System.out.println(sb);
    }

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static boolean union(int x, int y) {
        int A = find(x);
        int B = find(y);
        if (A == B) return false;
        p[A] = B;
        return true;
    }
}
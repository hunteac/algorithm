import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static class Island { // 섬 객체 구현 클래스
        int x; // 섬 x좌표
        int y; // 섬 y좌표
        Island (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] p; // 각 섬이 속한 집합의 대표섬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 섬의 수
            Island[] ilands = new Island[N + 1]; // 섬 배열
            double[][] edges = new double[N * (N - 1) / 2][3];
            p = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                int x = Integer.parseInt(st.nextToken());
                ilands[i] = new Island(x, 0);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                ilands[i].y = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine()); // 환경 부담 세율

            int node = 1;
            int edge = node + 1;

            for (int i = 0; i < edges.length; i++) { // 모든 간선 가중치
                int x1 = ilands[node].x;
                int y1 = ilands[node].y;
                int x2 = ilands[edge].x;
                int y2 = ilands[edge].y;
                edges[i][0] = node;
                edges[i][1] = edge++;
                edges[i][2] = E * (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                if (edge > N) {
                    node++;
                    edge = node + 1;
                }
            }

            for (int i = 1; i < N + 1; i++) {
                p[i] = i;
            }

            // 오름차순 정렬
            Arrays.sort(edges, new Comparator<double[]>() {
                @Override
                public int compare(double[] o1, double[] o2) {
                    if (o1[2] > o2[2]) return 1;
                    if (o1[2] < o2[2]) return -1;
                    return 0;
                }
            });

            double ans = 0; // 최소 비용
            int pick = 0; // 간선 연결 횟수

            for (int i = 0; i < edges.length; i++) {
                int x = (int) edges[i][0];
                int y = (int) edges[i][1];
                if (findset(x) != findset(y)) {
                    union(x, y);
                    ans += edges[i][2];
                    pick++;
                }
                if (pick == N - 1) break;
            }
            System.out.println("#" + tc + " " + Math.round(ans));
        }
    }

    static int findset(int x) {
        if (x == p[x]) return x;
        return p[x] = findset(p[x]);
    }

    static void union (int x, int y) {
        int A = findset(x);
        int B = findset(y);
        if (A != B) p[A] = B;
    }
}
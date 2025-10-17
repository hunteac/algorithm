import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<List<Integer>> road;
    public static boolean[][] visited;
    public static int[] dists;
    public static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        road = new ArrayList<>();
        dists = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
            dists[i] = Integer.MAX_VALUE;
        }

        dists[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            road.get(A).add(B);
        }

        dfs(X, 1);

        for (int i = 1; i <= N; i++) {
            if (dists[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() != 0) System.out.println(sb);
        else System.out.println(-1);
    }

    public static void dfs(int curr, int dist) {
        for (int i = 0; i < road.get(curr).size(); i++) {
            int next = road.get(curr).get(i);
            if (dists[next] > dist) {
                dists[next] = dist;
                if (dist < K) dfs(next, dist + 1);
            }
        }
    }
}
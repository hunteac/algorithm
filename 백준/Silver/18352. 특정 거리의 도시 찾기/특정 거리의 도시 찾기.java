import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> nodeList;
    static int[] dist;

    public static void dfs(int curr, int d, int max) {
        for (int i = 0; i < nodeList.get(curr).size(); i++) {
            int next = nodeList.get(curr).get(i);
            if (dist[next] > d + 1) {
                dist[next] = d + 1;
                if (d + 1 < max) {
                    dfs(next, d + 1, max);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nodeList.get(A).add(B);
        }

        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        dfs(X, 0, K);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() != 0) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
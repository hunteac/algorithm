import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    // 부모가 아닌 노드 제거
    static void remove(int curr) {
        visited[curr] = true;
        int len = tree[curr].size();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int next = tree[curr].get(idx);
            if (visited[next]) { // 부모 노드면 continue
                idx++;
                continue;
            }

            remove(next);

            tree[curr].remove(Integer.valueOf(next));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            tree[A].add(B); // 노드 연결
            tree[B].add(A);
        }

        for (int i = 1; i <= N; i++) remove(i);

        for (int i = 2; i <= N; i++) sb.append(tree[i].get(0)).append("\n");

        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>(); // 연결 요소를 담는 셋

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        if (M == 0) {
            System.out.println(N);
            return;
        }

        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (find(A) != find(B)) union(A, B);
        }

        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        System.out.println(set.size()); // 연결 요소 개수
    }
    // 파인드
    static int find (int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }
    // 유니온
    static void union (int x, int y) {
        int A = find(x);
        int B = find(y);

        if (A != B) p[B] = A;
    }
}
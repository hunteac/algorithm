import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p; // 집합 대표
    // 집합 대표 구하기
    static int find(int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }
    // 합집합 만들기
    static void union(int x, int y) {
        int A = find(x);
        int B = find(y);
        if (y != B) p[A] = B;
        else if (A != B) p[B] = A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행 계획 도시 수

        p = new int[N + 1];

        for (int i = 1; i <= N; i++) p[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    if (p[i] == p[j]) continue;

                    union(i, j); // 합집합 만들기
                }
            }
        }

        int[] travel = new int[M]; // 여행 경로

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) travel[i] = Integer.parseInt(st.nextToken());

        boolean chk = true; // 여행 가능 여부 체크

        for (int i = 0; i < M - 1; i++) {
            if (p[travel[i]] != p[travel[i + 1]]) chk = false;
        }

        if (chk) System.out.println("YES");
        else System.out.println("NO");
    }
}
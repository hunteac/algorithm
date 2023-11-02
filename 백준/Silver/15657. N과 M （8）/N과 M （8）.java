import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited; // 방문 체크
    static int[] nums;
    static int[] p;
    static int N;
    static int M;

    // 중복 순열 알고리즘
    static void permutation(int idx) {
        if (idx == M) {
            for (int i = 1; i < M; i++) { // 비내림차순이 아니면 종료
                if (p[i - 1] > p[i]) return;
            }

            for (int i = 0; i < M ;i++) { // 비내림차순 수열
                sb.append(p[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            p[idx] = nums[i];
            permutation(idx + 1); // 재귀 함수 호출
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        nums = new int[N];
        p = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums); // 오름차순 정렬

        permutation(0);

        System.out.println(sb);
    }
}
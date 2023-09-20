import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] visited; // 방문 체크
    static int N;
    static int M;

    static void permutation(int idx) {
        // 기저
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 재귀
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            nums[idx] = i;
            visited[i] = true;
            permutation(idx + 1);
            visited[i] = false; // 백트래킹
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N + 1];
        visited = new boolean[N + 1];
        permutation(0);
        System.out.println(sb);
    }
}
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] visited; // 방문 체크
    static int N;
    static int M;

    static void bTrack(int chk, int idx) {
        // 기저
        if (chk == M) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (idx == N) return;
        // 재귀
        visited[idx] = true;
        bTrack(chk + 1, idx + 1);
        visited[idx] = false;
        bTrack(chk, idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        bTrack(0, 0);
        System.out.println(sb);
    }
}
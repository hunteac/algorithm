import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] visited; // 방문 체크
    static int N;
    static int M;

    static void bTrack(int idx) {
        // 기저
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (idx > 0 && nums[idx - 1] > i) continue; // 비내림차순 백트래킹
            nums[idx] = i;
            bTrack(idx + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N + 1];
        visited = new boolean[N + 1];
        bTrack(0);
        System.out.println(sb);
    }
}
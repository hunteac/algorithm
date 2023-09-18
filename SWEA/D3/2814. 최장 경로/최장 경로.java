import java.util.Scanner;

public class Solution {
    public static int N; // 정점 수
    public static int M; // 간선 수
    public static int max; // 최장 경로 길이
    public static int[][] adjArr;
    public static boolean[] sel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            max = -1;
            adjArr = new int[N + 1][N + 1];
            sel = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                int A = sc.nextInt(); // 시작 정점
                int B = sc.nextInt(); // 끝 정점
                adjArr[A][B] = 1; // 무방향 그래프
                adjArr[B][A] = 1;
            }
            getLen(0, 0);
            System.out.println("#" + tc + " " + max);
        }
    }
    // 재귀를 이용한 최장 경로 구하기
    public static void getLen(int r, int len) {
        max = Math.max(max, len);
        // 재귀
        for (int i = 1; i < N + 1; i++) {
            if (sel[i] || r != 0 && adjArr[r][i] != 1) continue;
            sel[i] = true;
            getLen(i, len + 1);
            sel[i] = false; //
        }
    }
}
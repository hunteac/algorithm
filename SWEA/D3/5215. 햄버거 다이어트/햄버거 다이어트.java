import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static int[][] score; // r = 재료 점수, c = 재료 칼로리
    public static boolean[] sel; // 부분집합을 구하기 위한 배열
    public static int L; // 제한 칼로리
    public static int max; // 최대 점수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            L = sc.nextInt();
            score = new int[N][2];
            sel = new boolean[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    score[i][j] = sc.nextInt();
                }
            }
            max = 0;
            max = Math.max(max, powerSet(0));
            System.out.println("#" + tc + " " + max);
        }
    }
    // 재귀를 이용한 재료의 부분집합을 구하고 점수를 계산하는 메소드
    public static int powerSet(int N) {
        int fSum = 0; // 재료 맛 점수 총합
        int cSum = 0; // 재료 칼로리 총합
        // 기저파트
        if (N == score.length) {
            for (int i = 0; i < score.length; i++) {
                if (sel[i]) {
                    fSum += score[i][0];
                    cSum += score[i][1];
                }
            }
            if (cSum <= L) // 부분집합 칼로리 총합이 제한 칼로리랑 같거나 제한 칼로리보다 낮으면
                return fSum; // 맛 점수 총합 반환
            else
                return 0;
        }
        // 재귀파트
        sel[N] = false;
        max = Math.max(max, powerSet(N + 1));
        sel[N] = true;
        max = Math.max(max, powerSet(N + 1));
        return max;
    }
}
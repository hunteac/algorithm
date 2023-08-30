import java.util.Scanner;

public class Solution {
    public static int[][] foods; // 시너지 배열
    public static int[] nums; // 인덱스 배열
    public static int[] A; // A 음식 조합 배열
    public static int[] B; // B 음식 조합 배열
    public static int min; // 두 음식 맛 차이의 최소값


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 식재료 수
            foods = new int[N][N];
            nums = new int[N];
            A = new int[N / 2];
            B = new int[N / 2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    foods[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                nums[i] = i;
            }
            min = 20001;
            System.out.println("#" + tc + " " + combination(0, 0));
        }
    }
    // 재귀를 이용한 재료들의 조합을 구하고 최소 점수를 계산하는 메소드
    public static int combination(int idx, int sidx) {
        int Asum = 0; // A 음식 맛 총합
        int Bsum = 0; // B 음식 맛 총합
        // 기저파트
        if (sidx == A.length) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                boolean flag = false;
                for (int j = 0; j < A.length; j++) {
                    if (A[j] == i)
                        flag = true;
                }
                if (!flag)
                    B[cnt++] = i;
            }
            for (int i = 0; i < A.length; i++) {
                for (int j  = 0; j < A.length; j++) {
                    if (i != j) {
                        Asum += foods[A[i]][A[j]]; // A 음식 재료들 시너지 값 모두 더하기
                        Bsum += foods[B[i]][B[j]]; // B 음식 재료들 시너지 값 모두 더하기
                    }
                }
            }
            min = Math.min(min, Math.abs(Asum - Bsum));
            return min;
        }
        if (idx == foods.length)
            return 0;
        // 재귀파트
        A[sidx] = nums[idx];
        combination(idx + 1, sidx + 1);
        combination(idx + 1, sidx);
        return min;
    }
}
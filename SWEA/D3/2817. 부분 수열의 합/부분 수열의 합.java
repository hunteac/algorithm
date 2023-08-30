import java.util.Scanner;

public class Solution {
    public static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] sequence = new int[N];
            boolean[] sel = new boolean[N];
            for (int i = 0; i < N; i++) {
                sequence[i] = sc.nextInt();
            }
            cnt = 0; // 합이 K가 되는 부분 수열의 수
            count(sequence, sel, 0, K);
            System.out.println("#" + tc + " " + cnt);
        }
    }
    // 재귀를 이용한 부분 수열 수 구하는 메소드
    public static void count(int[] sequence, boolean[] sel, int idx, int K) {
        int sum = 0;
        // 기저파트
        if (idx == sequence.length) {
            for (int i = 0; i < sequence.length; i++) {
                if (sel[i]) {
                    sum += sequence[i];
                }
            }
            if (sum == K) cnt++;
            return;
        }
        // 재귀파트
        sel[idx] = true;
        count(sequence, sel, idx + 1, K); // 인덱스 선택
        sel[idx] = false;
        count(sequence, sel, idx + 1, K); // 인덱스 선택 안하기
    }
}
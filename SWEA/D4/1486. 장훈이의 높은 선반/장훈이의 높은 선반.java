import java.util.Scanner;

public class Solution {
    static int N, B, ans; // 점원 수, 선반 높이, 출력 값
    static int[] H; // 점원들의 키 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            B = sc.nextInt();
            H = new int[N];
            for (int i = 0; i < N; i++) {
                H[i] = sc.nextInt();
            }
            ans = Integer.MAX_VALUE;
            // 비트마스킹을 이용한 부분집합 구하기
            for (int i = 0; i < (1<<N); i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    // 조건문이 참이면 j번째 점원이 탑에 포함
                    if ((i & (1<<j)) != 0)
                        sum += H[j];
                }
                if (sum >= B && sum < ans)
                    ans = sum;
            }
            System.out.println("#" + tc + " " + (ans - B));
        }
    }
}
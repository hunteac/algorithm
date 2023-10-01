import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int P = sc.nextInt(); // 1리터당 P원
            int Q = sc.nextInt(); // 기본요금
            int R = sc.nextInt(); // 월간 사용량 기준
            int S = sc.nextInt(); // 초과 리터 요금
            int W = sc.nextInt(); // 월간 사용량

            if (W > R)
                System.out.println("#" + tc + " " + Math.min(P * W, Q + (W - R) * S));
            else
                System.out.println("#" + tc + " " + Math.min(P * W, Q));
        }
    }
}
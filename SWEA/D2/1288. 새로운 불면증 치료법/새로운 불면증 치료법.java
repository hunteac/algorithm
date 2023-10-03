import java.util.*;

class Solution {
    static boolean[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            nums = new boolean[10];

            int num = 1;
            int cnt = 0;
            while (true) {
                String tmp = String.valueOf(N * num);

                for (int i = 0; i < tmp.length(); i++) {
                    nums[tmp.charAt(i) - '0'] = true; // 등장한 숫자 index = true
                }

                cnt = 0;
                for (int i = 0; i < 10; i++) {
                    if (nums[i]) cnt++; // 모든 숫자가 등장했는지 확인
                }

                if (cnt == 10) break; // 0 ~ 9 모두 등장하면 반복문 탈출

                num++;
            }

            System.out.println("#" + tc + " " + N * num);
        }
    }
}
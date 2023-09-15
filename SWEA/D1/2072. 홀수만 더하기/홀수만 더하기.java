import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1;  tc <= T; tc++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) { // 홀수만 더하기
                int num = sc.nextInt();
                if (num % 2 == 1) sum += num;
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
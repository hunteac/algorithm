import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1;  tc <= T; tc++) {
            int max = -1;
            for (int i = 0; i < 10; i++) {
                max = Math.max(max, sc.nextInt()); // 최댓값 구하기
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
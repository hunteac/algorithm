import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1;  tc <= T; tc++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) { // 총합 구하기
                sum += sc.nextInt();
            }
            System.out.println("#" + tc + " " + Math.round(sum / 10.0)); // 소수점 첫째 자리에서 반올림한 평균 출력하기
        }
    }
}
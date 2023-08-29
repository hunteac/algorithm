import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] bit = new int[N];
            String answer = "ON"; // 기본출력값 = ON
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                bit[cnt++] = M % 2; // N길이의 비트 담기
                M /= 2;
            }
            for (int i = 0; i < N; i++) {
                if (bit[i] == 0) { // 비트가 꺼져있다면
                    answer = "OFF"; // 출력값 = OFF
                    break; // 반복문 탈출
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
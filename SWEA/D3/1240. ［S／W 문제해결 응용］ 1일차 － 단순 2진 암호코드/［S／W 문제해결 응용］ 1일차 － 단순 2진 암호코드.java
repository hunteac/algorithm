import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static String[] code = { "1011000", "1001100", "1100100", "1011110", "1100010", "1000110", "1111010", "1101110", "1110110", "1101000" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 배열 세로 크기
            int M = sc.nextInt(); // 배열 가로 크기
            char[][] codes = new char[N][M];
            int[] nums = new int[8];
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    codes[i][j] = s.charAt(j); // 암호 넣기
                }
            }
            int cnt = 0;
            int cnt2 = 0;
            char[] carr = new char[7];
            Out: for (int i = N - 1; i >= 0; i--) { // 거꾸로 해독
                for (int j = M - 1; j >= 0; j--) {
                    if (codes[i][j] == '1') { // 암호문 시작
                        for (int k = 0; k < 56; k++) {
                            carr[cnt++] = codes[i][j - k];
                            if (cnt == 7) { // 비트가 7개면
                                String s = new String(carr);
                                nums[cnt2++] = interpret(s); // 문자열 해독
                                cnt = 0;
                            }
                        }
                        break Out;
                    }
                }
            }
            int answer = 0;
            int a = 0;
            int b = 0;
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0)
                    a += nums[i];
                else
                    b += nums[i];
            }
            if ((a + b * 3) % 10 == 0)
                answer = a + b;
            System.out.println("#" + tc + " " + answer);
        }
    }
    public static int interpret(String s) {
        for (int i = 0; i < 10; i++) {
            if (s.equals(code[i])) // 문자열이 배열 안의 코드와 동일하다면
                return i; // 해당 숫자 반환
        }
        return 0;
    }
}
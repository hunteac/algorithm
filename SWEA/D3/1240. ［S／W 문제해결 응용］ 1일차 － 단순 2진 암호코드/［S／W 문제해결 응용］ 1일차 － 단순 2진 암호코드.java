import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 배열 세로 크기
            int M = sc.nextInt(); // 배열 가로 크기
            char[][] code = new char[N][M];
            int[] nums = new int[8];
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    code[i][j] = s.charAt(j); // 암호 넣기
                }
            }
            int cnt = 0;
            int cnt2 = 0;
            char[] carr = new char[7];
            Out: for (int i = N - 1; i >= 0; i--) {
                for (int j = M - 1; j >= 0; j--) {
                    if (code[i][j] == '1') { // 거꾸로 해독
                        for (int k = 0; k < 56; k++) {
                            carr[cnt++] = code[i][j - k];
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
        if (s.equals("1011000"))
            return 0;
        else if (s.equals("1001100"))
            return 1;
        else if (s.equals("1100100"))
            return 2;
        else if (s.equals("1011110"))
            return 3;
        else if (s.equals("1100010"))
            return 4;
        else if (s.equals("1000110"))
            return 5;
        else if (s.equals("1111010"))
            return 6;
        else if (s.equals("1101110"))
            return 7;
        else if (s.equals("1110110"))
            return 8;
        else if (s.equals("1101000"))
            return 9;
        return 0;
    }
}
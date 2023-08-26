import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            char[][] flag = new char[N][M];
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    flag[i][j] = s.charAt(j);
                }
            }
            int min = N * M;
            int cnt = 0;
            int num = 0;
            int x = 0;
            int y = 1;
            int z = 2;
            int tmpy = 0;
            int tmpz = 0;
            // 반복 횟수 구하기
            for (int i = 1; i < N - 1; i++) {
            	num += i;
            }
            while (num > 0) {
            	x = 0;
            	if (z == N) {
            		y++;
            		z = y + 1;
            	}
            	while (x < y) {
            		for (int c = 0; c < M; c++) {
            			if (flag[x][c] != 'W') // 흰색으로 바꾸는 횟수 구하기
            				cnt++;
            		}
            		x++;
            	}
            	tmpy = y;
            	while (tmpy < z) {
            		for (int c = 0; c < M; c++) {
            			if (flag[tmpy][c] != 'B') // 파란색으로 바꾸는 횟수 구하기
            				cnt++;
            		}
            		tmpy++;
            	}
            	tmpz = z;
            	while (tmpz < N) {
            		for (int c = 0; c < M; c++) {
            			if (flag[tmpz][c] != 'R') // 빨간색으로 바꾸는 횟수 구하기
            				cnt++;
            		}
            		tmpz++;
        		}
            	min = Math.min(cnt, min); // 바꾸는 최소값 구하기
            	z++;
            	num--;
            	cnt = 0;
            }
            System.out.println("#" + tc + " " + min);
        }
    }
}
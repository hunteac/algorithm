import java.util.*;

class Solution {
    static boolean[][] visited; // 방문 체크
    static int[][] honey; // 벌통
    static boolean[] sel; // 부분 집합
    static int[] w1; // 일꾼 1
    static int[] w2; // 일꾼 2
    static int N; // 크기
    static int M; // 채취할 수 있는 벌통 수
    static int C; // 채취할 수 있는 최대 양
    static int max; // 최대 수익
    static int wMax; // 두번째 일꾼이 채취하는 최대 꿀

    static void getHoney(int r, int c, int sum) {
        for (int i = r; i < N; i++) {
            if (i == r) { // 첫 번째 일군이 채취한 행
                Outer: for (int j = c + 1; j < N; j++) {
                    for (int m = 0; m < M; m++) {
                        if (j + m >= N) break Outer;
                        w2[m] = honey[i][j + m];
                    }
                    wMax = 0;
                    max = Math.max(max, sum + powerSet(0, w2));
                }
            } else { // 이후 행
                Outer: for (int j = 0; j < N; j++) {
                    for (int m = 0; m < M; m++) {
                        if (j + m >= N) break Outer;
                        w2[m] = honey[i][j + m];
                    }
                    wMax = 0;
                    max = Math.max(max, sum + powerSet(0, w2));
                }
            }
        }
    }

    static int powerSet(int idx, int[] w) {
        // 기저
        if (idx == M) {
            int sum = 0; // 합
            int squareSum = 0; // 제곱합
            for (int i = 0; i < M; i++) {
                if (sel[i]) {
                    sum += w[i];
                    squareSum += (int) Math.pow(w[i], 2);
                }
            }

            if (sum <= C) {
                wMax = Math.max(wMax, squareSum);
            }
            return wMax;
        }
        // 재귀
        sel[idx] = true;
        powerSet(idx + 1, w);
        sel[idx] = false;
        powerSet(idx + 1, w);
        return wMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();

            visited = new boolean[N][N];
            honey = new int[N][N];

            sel = new boolean[N];
            w1 = new int[M];
            w2 = new int[M];

            max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    honey[i][j] = sc.nextInt();
                }
            }

            int last = 0;
            for (int i = 0; i < N; i++) {
                Outer: for (int j = 0; j < N; j++) {
                    for (int m = 0; m < M; m++) {
                        if (j + m >= N) break Outer;
                        if (j + m < N) {
                            visited[i][j + m] = true;
                            w1[m] = honey[i][j + m];
                        }
                        last = j + m;
                    }
                    wMax = 0;
                    getHoney(i, last, powerSet(0, w1));
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
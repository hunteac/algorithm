import java.util.Scanner;

public class Main {

    static char[][] stars;

    static void recursion(int x, int y, int N, boolean blank) {
        // 공백칸일 경우
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 블럭
        if (N == 1) {
            stars[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) recursion(i, j, size, true);
                else recursion(i, j, size, false);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        stars = new char[N][N];

        recursion(0, 0, N, false);

        for (char[] star : stars) {
            for (int i = 0; i < N; i++) {
                sb.append(star[i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
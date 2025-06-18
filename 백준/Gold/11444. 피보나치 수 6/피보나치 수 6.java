import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }

        long[][] matrix = {{1, 1}, {1, 0}};

        long[][] result = getMatrix(matrix, N - 1);

        System.out.println((result[1][0] + result[1][1]) % 1000000007);
    }

    public static long[][] getMatrix(long[][] matrix, long N) {
        if (N == 1) return matrix;

        long[][] tmp;

        if (N % 2 == 0) {
            tmp = getMatrix(matrix, N / 2);
            tmp = matrixPower(tmp, tmp);
        } else {
            tmp = getMatrix(matrix, N - 1);
            tmp = matrixPower(tmp, matrix);
        }

        return tmp;
    }

    public static long[][] matrixPower(long[][] A, long[][] B) {
        long[][] matrix = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long num = 0;
                for (int k = 0; k < 2; k++) {
                    num += A[i][k] * B[k][j] % 1000000007;
                }

                matrix[i][j] = num % 1000000007;
            }
        }

        return matrix;
    }
}
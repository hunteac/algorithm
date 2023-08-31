import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(N,0, 1));
    }
    // 재귀를 이용한 피보나치 수 구하는 메소드
    public static int fibonacci(int N, int i, int j) {
        // 기저파트
        if (N == 0) return i; // 0 시작
        if (N == 1) return j; // 1 시작
        // 재귀파트
        return fibonacci(N - 2, i, j) + fibonacci(N - 1, i, j); // N - 2 번째 + N - 1 번째
    }
}
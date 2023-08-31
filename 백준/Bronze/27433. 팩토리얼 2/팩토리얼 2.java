import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        System.out.println(factorial(N));
    }
    // 재귀를 이용한 팩토리얼 구하는 메소드
    public static long factorial(long N) {
        if (N == 0) return 1;
        if (N == 1) return N;
        return N * factorial(N - 1);
    }
}
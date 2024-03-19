import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long dfs(int a, int n, int c) {
        if (n == 1) {
            return a % c;
        } else if (n % 2 == 0) {
            long num = dfs(a, n / 2, c);
            return (num * num) % c;
        } else {
            long num = dfs(a, (n - 1) / 2, c);
            return ((num * num) % c * a) % c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(dfs(A, B, C));
    }
}
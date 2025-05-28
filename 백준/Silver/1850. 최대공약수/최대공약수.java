import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = getGcd(A, B);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < gcd; i++) result.append("1");

        System.out.println(result);
    }

    public static long getGcd(long A, long B) {
        if (A % B == 0) return B;

        return getGcd(B, A % B);
    }
}
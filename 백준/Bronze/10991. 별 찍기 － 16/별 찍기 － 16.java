import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean isNEven = N % 2 == 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N + i; j++) {
                boolean isIEven = i % 2 == 0;
                boolean isJEven = j % 2 == 0;
                boolean isJInRange = j >= N - i - 1 && j < N + i;

                if (isJInRange) {
                    if (isNEven) {
                        if ((isIEven && !isJEven) || (!isIEven && isJEven)) sb.append("*");
                        else sb.append(" ");
                    } else {
                        if ((isIEven && isJEven) || (!isIEven && !isJEven)) sb.append("*");
                        else sb.append(" ");
                    }
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
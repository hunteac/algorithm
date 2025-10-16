import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0 && C == 0) {
                break;
            }

            if (checkTriangle(A, B, C)) {
                if (A == B && B == C) {
                    sb.append("Equilateral").append("\n");
                } else if (A == B || B == C || A == C) {
                    sb.append("Isosceles").append("\n");
                } else {
                    sb.append("Scalene").append("\n");
                }
            } else {
                sb.append("Invalid").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean checkTriangle(int A, int B, int C) {
        int max = Math.max(A, B);
        max = Math.max(max, C);

        if (A == max && A < B + C) {
            return true;
        } else if (B == max && B < A + C) {
            return true;
        } else if (C == max && C < A + B) {
            return true;
        }

        return false;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        while (str != null) {
            int A = 0;
            int B = 0;
            int C = 0;
            int D = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'a' && c <= 'z') A++;
                else if (c >= 'A' && c <= 'Z') B++;
                else if (c >= '0' && c <= '9') C++;
                else if (c == ' ') D++;
            }

            sb.append(A).append(" ");
            sb.append(B).append(" ");
            sb.append(C).append(" ");
            sb.append(D).append("\n");

            str = br.readLine();
        }

        System.out.println(sb);
    }
}
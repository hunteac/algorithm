import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            String tmp = "";

            for (int j = 0; j < name.length(); j++) {
                tmp += String.valueOf(name.charAt(j)).toLowerCase();
            }

            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}
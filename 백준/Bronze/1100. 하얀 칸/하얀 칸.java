import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] chess = new String[8][8];

        // 하얀 칸 위에 있는 말 수
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0 && str.charAt(j) == 'F') {
                    cnt++;
                } else if (i % 2 == 1 && j % 2 == 1 && str.charAt(j) == 'F') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
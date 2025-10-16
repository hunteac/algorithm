import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());

        int[] heights;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());

            sb.append(st.nextToken()).append(" ");

            heights = new int[20];

            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for (int j = 1; j < 20; j++) {
                int curr = heights[j];
                for (int k = j - 1; k >= 0; k--) {
                    if (curr > heights[k]) {
                        break;
                    } else {
                        heights[k + 1] = heights[k];
                        heights[k] = curr;
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
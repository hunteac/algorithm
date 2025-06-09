import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] numArr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            visited = new boolean[N + 1];
            numArr = new int[N + 1];
            cnt = 0;

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) numArr[j] = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= N; j++) if (!visited[j]) findCycle(j, numArr[j]);

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static void findCycle(int target, int curr) {
        visited[curr] = true;

        if (target == curr) cnt++;
        else findCycle(target, numArr[curr]);
    }
}
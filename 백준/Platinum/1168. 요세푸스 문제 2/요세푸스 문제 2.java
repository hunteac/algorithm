import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) list.add(i);

        sb.append("<");

        int target = 0;

        for (int i = 0; i < N; i++) {
            target += K - 1;

            if (target >= list.size()) target %= list.size();

            if (i != N - 1) sb.append(list.get(target)).append(", ");
            else sb.append(list.get(target)).append(">");

            list.remove(target);
        }

        System.out.println(sb);
    }
}
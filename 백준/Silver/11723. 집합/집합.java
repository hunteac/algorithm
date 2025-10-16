import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String com = st.nextToken();

            if ("all".equals(com)) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
                continue;
            } else if ("empty".equals(com)) {
                set.clear();
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if ("add".equals(com)) {
                set.add(num);
            } else if ("remove".equals(com)) {
                set.remove(num);
            } else if ("check".equals(com)) {
                if (set.contains(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if ("toggle".equals(com)) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
        }

        System.out.println(sb);
    }
}
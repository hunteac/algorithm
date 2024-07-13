import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();

        HashMap<String, Integer> games = new HashMap<>();
        HashSet<String> names = new HashSet<>();

        games.put("Y", 1);
        games.put("F", 2);
        games.put("O", 3);

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            names.add(name);
        }

        System.out.println(names.size() / games.get(type));
    }
}
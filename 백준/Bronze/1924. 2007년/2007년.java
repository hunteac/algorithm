import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "MON");
        map.put(1, "TUE");
        map.put(2, "WED");
        map.put(3, "THU");
        map.put(4, "FRI");
        map.put(5, "SAT");
        map.put(6, "SUN");

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int num = day - 1;

        for (int i = 0; i < month - 1; i++) {
            num += days[i];
        }

        num %= 7;

        System.out.println(map.get(num));
    }
}
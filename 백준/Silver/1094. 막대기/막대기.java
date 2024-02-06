import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());

        LinkedList<Integer> sticks = new LinkedList<>();
        sticks.add(64);

        while (true) {
            int min = sticks.removeFirst(); // 가장 짧은 막대
            int sum = 0; // 막대 총합

            if (min == X) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i < sticks.size(); i++) sum += sticks.get(i);

            min /= 2;

            if (sum + min >= X) {
                sticks.addFirst(min); // 버리기
            } else {
                sticks.addFirst(min);
                sticks.addFirst(min);
            }

            sum = 0;
            for (int i = 0; i < sticks.size(); i++) sum += sticks.get(i);
            if (sum == X) {
                System.out.println(sticks.size());
                return;
            }
        }
    }
}
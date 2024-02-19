import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> list;

    static void func(long num, int idx) {
        if (idx > 10) return;

        list.add(num);

        for (int i = 0; i < num % 10; i++) {
            func((num * 10) + i, idx + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        if (N <= 10) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < 10; i++) {
            func(i, 1);
        }

        if (N >= list.size()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }
}
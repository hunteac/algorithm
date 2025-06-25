import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int value;

        Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewelry jewelry) {
            return this.weight - jewelry.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewelries.add(new Jewelry(weight, value));
        }

        ArrayList<Integer> bags = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bags);

        PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());

        long max = 0;

        for (int i = 0; i < K; i++) {
            int bWeight = bags.get(i);

            while (!jewelries.isEmpty()) {
                Jewelry jewelry = jewelries.peek();

                int jWeight = jewelry.weight;
                int jValue = jewelry.value;

                if (jWeight <= bWeight) {
                    jewelries.poll();
                    values.add(jValue);
                } else {
                    break;
                }
            }

            if (!values.isEmpty()) max += values.poll();
        }

        System.out.println(max);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Country implements Comparable<Country> {
        int number;
        int gold;
        int silver;
        int bronze;

        Country(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Country c) {
            if (this.gold != c.gold) return c.gold - this.gold;
            if (this.silver != c.silver) return c.silver - this.silver;
            return c.bronze - this.bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Country> pq = new PriorityQueue<>();

        int number, gold, silver, bronze;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            number = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());

            pq.add(new Country(number, gold, silver, bronze));
        }

        int beforeGold = 0;
        int beforeSilver = 0;
        int beforeBronze = 0;
        int rank = 1;
        int equal = 0;

        while (!pq.isEmpty()) {
            Country c = pq.poll();
            gold = c.gold;
            silver = c.silver;
            bronze = c.bronze;

            if (gold != beforeGold || silver != beforeSilver || bronze != beforeBronze) {
                rank += equal;
                equal = 1;
            } else {
                equal++;
            }

            beforeGold = gold;
            beforeSilver = silver;
            beforeBronze = bronze;

            if (c.number == K) {
                System.out.println(rank);
                return;
            }
        }
    }
}
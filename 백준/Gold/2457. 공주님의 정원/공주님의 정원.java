import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Flower implements Comparable<Flower> {
        int startM; // 시작 월
        int startD; // 시작 일
        int endM; // 종료 월
        int endD; // 종료 일
        Flower (int startM, int startD, int endM, int endD) {
            this.startM = startM;
            this.startD = startD;
            this.endM = endM;
            this.endD = endD;
        }

        @Override
        public int compareTo(Flower o) {
            if (o.startM == this.startM) return this.startD - o.startD;
            return this.startM - o.startM;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Flower> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startM = Integer.parseInt(st.nextToken()); // 시작 날짜
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken()); // 종료 날짜
            int endD = Integer.parseInt(st.nextToken());

            pq.add(new Flower(startM, startD, endM, endD));
        }

        ArrayList<Flower> flowers = new ArrayList<>();

        while (!pq.isEmpty()) {
            Flower f = pq.poll();

            int startM = f.startM;
            int startD = f.startD;
            int endM = f.endM;
            int endD = f.endD;

            if (!flowers.isEmpty()) {
                int size = flowers.size();
                int rightM = flowers.get(size - 1).endM;
                int rightD = flowers.get(size - 1).endD;

                if (startM > rightM || (startM == rightM && startD > rightD)) continue;
                if (endM < rightM || (endM == rightM && endD <= rightD)) continue;

                if (size == 1) {
                    if ((startM < 3 && endM >= 3) || (startM == 3 && startD == 1)) {
                        flowers.remove(0);
                    }
                    flowers.add(new Flower(startM, startD, endM, endD));
                } else {
                    if (startM < flowers.get(size - 2).endM || (startM == flowers.get(size - 2).endM && startD <= flowers.get(size - 2).endD)) {
                        flowers.remove(size - 1);
                        flowers.add(new Flower(startM, startD, endM, endD));
                    } else {
                        flowers.add(new Flower(startM, startD, endM, endD));
                    }
                }
            } else {
                if ((startM < 3 && endM >= 3) || (startM == 3 && startD == 1)) {
                    flowers.add(new Flower(startM, startD, endM, endD));
                }
            }
        }

        boolean chk = false;
        int cnt = 0;

        for (int i = 0; i < flowers.size(); i++) {
            Flower f = flowers.get(i);

            cnt++;

            if (f.endM > 11) {
                chk = true;
                break;
            }
        }

        if (!chk) System.out.println(0);
        else System.out.println(cnt);
    }
}
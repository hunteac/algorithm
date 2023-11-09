import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<sum> pq = new PriorityQueue<>();
        
        int n = Integer.parseInt(br.readLine());
        int min = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            pq.add(new sum(n - i * i, 1));
        }
        
        sum tmp = null;
        
        Outer: while (!pq.isEmpty()) {
            tmp = pq.poll();
            
            if (tmp.sum < 0) continue;
            if (tmp.sum == 0) {
                break;
            } 
            
            for (int i = 1; i <= Math.sqrt(n); i++) {
                int chk = tmp.sum - i * i;
                if (chk == 0) {
                    tmp.cnt++;
                    break Outer;
                }
                if (chk < 0) continue;
                pq.add(new sum(chk, tmp.cnt + 1));
            }
         }
        
        System.out.println(tmp.cnt);
    }
    
    static class sum implements Comparable<sum> {
        int sum;
        int cnt;
        
        sum (int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(sum o) {
            if(this.cnt < o.cnt ) {
                return -1;
            }else if(this.cnt > o.cnt) {
                return 1;
            }
            
            return Integer.compare(this.sum, o.sum);
        }
    }
}
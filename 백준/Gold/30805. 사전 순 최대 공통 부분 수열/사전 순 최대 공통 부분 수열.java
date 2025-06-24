import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Num implements Comparable<Num>{
		int idx;
		int value;
		
		Num(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		@Override
		public int compareTo(Num num) {
			return this.value == num.value ? this.idx - num.idx : num.value - this.value;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        PriorityQueue<Num> aQueue = new PriorityQueue<>();
        PriorityQueue<Num> bQueue = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        	aQueue.add(new Num(i, A[i]));
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
        	B[i] = Integer.parseInt(st.nextToken());
        	bQueue.add(new Num(i, B[i]));
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();

        int lastAIdx = -1;
        int lastBIdx = -1;
        
        while (!aQueue.isEmpty()) {
        	Num aMax = aQueue.poll();
        	int aIdx = aMax.idx;
        	int aValue = aMax.value;
        	
        	if (lastAIdx > aIdx) continue;
        	
        	while (!bQueue.isEmpty()) {
        		Num bMax = bQueue.peek();
        		int bIdx = bMax.idx;
            	int bValue = bMax.value;
        		
            	if (bValue < aValue) break;
            	
            	bQueue.poll();
            	
            	if (aValue == bValue && lastBIdx < bIdx) {
            		result.add(aValue);
            		lastAIdx = aIdx;
            		lastBIdx = bIdx;
            		break;
            	}
        	}
        }
        
        sb.append(result.size()).append("\n");
        for (Integer num : result) sb.append(num).append(" ");

        System.out.println(sb);
    }
}
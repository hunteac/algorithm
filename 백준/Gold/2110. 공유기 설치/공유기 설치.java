import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] places = new int[N];
        
        for (int i = 0; i < N; i++) {
        	places[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(places);
        
        int left = 1;
        int right = places[N - 1] - places[0] + 1;
        int mid = 0;
        
        while (left < right) {
        	mid = (left + right) / 2;
        	
        	int cnt = getCnt(places, mid);
        	
        	// 결정 로직
        	if (C <= cnt) {
        		left = mid + 1;
        	} else if (C > cnt) {
        		right = mid;
        	}
        }

        System.out.println(left - 1);
    }
    
    public static int getCnt(int[] places, int dist) {
    	int cnt = 1, before = 0;
    	
    	for (int i = 1; i < places.length; i++) {
    		if (places[i] - places[before] >= dist) {
    			cnt++;
    			before = i;
    		}
    	}
    	
    	return cnt;
    }
}
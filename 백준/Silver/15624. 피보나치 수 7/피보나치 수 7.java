import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
        	System.out.println(0);
        	return;
        }
        
        int[] pibo = new int[N + 1];
        
        pibo[1] = 1;
        
        for (int i = 2; i <= N; i++) {
        	pibo[i] = (pibo[i - 1] + pibo[i - 2]) % 1000000007;
        }

        System.out.println(pibo[N]);
    }
}

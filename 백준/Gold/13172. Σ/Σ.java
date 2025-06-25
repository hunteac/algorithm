import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public final static int mod = 1000000007;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int M = Integer.parseInt(br.readLine());
        long sum = 0;
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	long N = Integer.parseInt(st.nextToken());
        	long S = Integer.parseInt(st.nextToken());
        	
        	sum = (sum + modular(N, S)) % mod;
        }

        System.out.println(sum);
    }
    
    public static long modular(long N, long S) {
    	if (S % N == 0) return S / N;
    	
    	long gcd = N > S ? getGcd(S, N) : getGcd(N, S);
    	
        N /= gcd;
        S /= gcd;
        
    	return ((S % mod) * getPower(N, mod - 2)) % mod;
    }
    
    public static long getGcd(long A, long B) {
    	while (B != 0) {
    		long tmp = B;
    		B = A % B;
    		A = tmp;
    	}
    	
    	return A;
    }
    
    public static long getPower(long N, int power) {
    	if (power == 1) return N;
    	
    	if (power % 2 == 0) {
    		long half = getPower(N, power / 2);
    		return (half * half) % mod;
    	} else {
    		return (getPower(N, power - 1) * N) % mod;
    	}
    }
}
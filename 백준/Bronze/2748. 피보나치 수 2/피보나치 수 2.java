import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static long[] piboArr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        piboArr = new long[N + 1];
        
        piboArr[1] = 1;
        if (N > 1) piboArr[2] = 1;

        long result = pibo(N);
        
        System.out.println(result);
    }
    
    public static long pibo(int n) {
    	if (piboArr[n] != 0) return piboArr[n];
    	else return piboArr[n] = pibo(n - 1) + pibo(n - 2); 
    }
}
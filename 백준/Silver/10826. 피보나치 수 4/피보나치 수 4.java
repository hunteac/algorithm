import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static BigInteger[] piboArr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
        	System.out.println(0);
        	return;
        }
        
        piboArr = new BigInteger[N + 1];
        
        piboArr[1] = BigInteger.ONE;
        if (N > 1) piboArr[2] = BigInteger.ONE;
        
        for (int i = 3; i <= N; i++) {
        	piboArr[i] = new BigInteger("0");
        	piboArr[i] = piboArr[i - 1].add(piboArr[i - 2]);
        }

        System.out.println(piboArr[N]);
    }
}
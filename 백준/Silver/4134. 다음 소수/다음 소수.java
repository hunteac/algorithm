import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
        	long num = Long.parseLong(br.readLine());
        	long prime = num;
        	while (true) {
        		// 0과 1일 경우 발생하는 예외 처리
        		if (prime == 0 || prime == 1)
        			prime = 2;
        		// 수가 소수라면 반복문 탈출
        		if (getPrime(prime))
        			break;
        		prime++;
        	}
        	System.out.println(prime);
        }
    }
	// 제곱근을 이용해 소수를 판단하는 메소드
    public static boolean getPrime(long a) {
    	for (int i = 2; i <= Math.sqrt(a); i++) {
    		if (a % i == 0)
    			return false;
    	}
    	return true;
    }
}
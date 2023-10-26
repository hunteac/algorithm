import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		BigInteger hash = new BigInteger("0");
		BigInteger b = new BigInteger("1234567891");
		
		for (int i = 0; i < N; i++) {
			String str = String.valueOf(s.charAt(i) - 96);
			BigInteger num = new BigInteger(str);
			BigInteger m = new BigInteger("31");
					
			for (int j = 0; j < i; j++) {
				num = num.multiply(m);
			}
			
			hash = hash.add(num);
		}
		
		System.out.println(hash.mod(b));
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String isbn = br.readLine();
        
        int sum = 0;
        int weight = 0;
        
        for (int i = 0; i < 12; i++) {
        	char ch = isbn.charAt(i);
        	if (ch == '*') {
        		weight = (i % 2 == 0) ? 1 : 3;
        	} else {
        		int digit = ch - '0';
        		sum += (i % 2 == 0) ? digit : digit * 3;
        	}
        }
        
        int m = isbn.charAt(12) - '0';
        int target = m == 0 ? 0 : 10 - m;
        
        for (int num = 0; num <= 9; num++) {
        	if ((sum + num * weight) % 10 == target) {
        		System.out.println(num);
        		break;
        	}
        }
    }
}
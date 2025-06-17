import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strs = new String[3];

        boolean flag = false;
        int num = 0;
        
        for (int i = 0; i < 3; i++) {
        	strs[i] = br.readLine();
        	
        	if (strs[i].charAt(0) != 'F' && strs[i].charAt(0) != 'B') {
        		num = Integer.parseInt(strs[i]);
        		flag = true;
        	}
        	
        	if (flag) {
        		num++;
        	}
        }
        
        if (num % 15 == 0) System.out.println("FizzBuzz");
        else if (num % 3 == 0) System.out.println("Fizz");
        else if (num % 5 == 0) System.out.println("Buzz");
        else System.out.println(num);
    }
}
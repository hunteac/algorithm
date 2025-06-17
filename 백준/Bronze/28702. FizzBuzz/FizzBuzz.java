import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        int max = 0, before = 0;
        
        if (A.matches("[+-]?\\d*(\\.\\d+)?")) {
        	max = Integer.parseInt(A);
        	before = 3;
        }
        
        if (B.matches("[+-]?\\d*(\\.\\d+)?")) {
        	max = Integer.parseInt(B);
        	before = 2;
        }
        
        if (C.matches("[+-]?\\d*(\\.\\d+)?")) {
        	max = Integer.parseInt(C);
        	before = 1;
        }
        
        int next = max + before;
        
        if (next % 3 == 0 && next % 5 == 0) System.out.println("FizzBuzz");
        else if (next % 3 == 0) System.out.println("Fizz");
        else if (next % 5 == 0) System.out.println("Buzz");
        else System.out.println(next);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	double d = 4;
    	
    	for (double i = 1; i <= n; i++) {
    		d = d + (Math.pow(2, i) * (Math.pow(2, i) + 1) 
    			- Math.pow(4, i - 1));
    	}
    	System.out.println((int) d);
    	
    	sc.close();
    	
    }
}
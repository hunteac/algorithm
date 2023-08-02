import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int sum = 0;
    	
    	while (true) {
    		int n = sc.nextInt();
    		sum = 0;
    		
    		if (n == -1) break;
    	
    		System.out.printf("%d ", n);
    		
    		for (int i = 1; i < n; i++) {
    			if (n % i == 0) sum += i;
    		}
    		
    		if (n == sum) {
    			System.out.print("=");
    			for (int i = 1; i < n; i++) {
    				if (n % i == 0) {
    					sum -= i;
    					if (sum != 0)
    						System.out.printf(" %d +", i);
    					else {
    						System.out.printf(" %d", i);
    						break;
    					}
    				}
    			}
    		} else System.out.print("is NOT perfect.");
    		
    		System.out.println();
    		
    	}
    	sc.close();
    	
    }
}
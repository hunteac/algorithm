import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 1; j <= 2 * n - 1; j++) {
    			if (j < n - i) 
    				System.out.print(" ");
    			else if (j >= n - i && j <= n + i)
    				System.out.print("*");
    		}
    		System.out.println();
    	}
    	
    	for (int i = n - 1; i >= 1; i--) {
    		for (int j = 1; j <= 2 * n - 1; j++) {
    			if (j <= n - i) 
    				System.out.print(" ");
    			else if (j > n - i && j < n + i)
    				System.out.print("*");
    		}
    		System.out.println();
    	}
   	} 
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	for (int i = 0; i < n; i++) {
    		int m = sc.nextInt();
    		System.out.print(m / 25 + " ");
    		m = m % 25;
    		System.out.print(m / 10 + " ");
    		m = m % 10;
    		System.out.print(m / 5 + " ");
    		m = m % 5;
    		System.out.print(m / 1 + " ");
    		System.out.println();
    	}
    }
}
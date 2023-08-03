import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n1 = sc.nextInt();
    	int n2 = sc.nextInt();
    	int n3 = sc.nextInt();
    	
    	if (n1 + n2 + n3 == 180) {
    		if (n1 == n2 && n2 == n3 && n1 == n3)
    			System.out.println("Equilateral");
    		else if (n1 == n2 || n2 == n3 || n1 == n3)
    			System.out.println("Isosceles");
    		else if (n1 != n2 && n2 != n3 && n1 != n3)
    			System.out.println("Scalene");
    	} else System.out.println("Error");
    	
    	sc.close();
    		
    }
}
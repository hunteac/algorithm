import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int v = sc.nextInt();
    	int num = 0;
    	
    	if (a - b == 1) {
    		num = v / (a - b) - b;
    	} else if (a - b > 1) {
    		if ((v - a) % (a - b) == 0) {
    			num = (v - a) / (a - b) + 1;
    		} else {
    			num = (v - a) / (a - b) + 2;
    		}
    	}
    	System.out.println(num);
    	
    }
}
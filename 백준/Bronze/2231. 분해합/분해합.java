import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int sum = 0;
    	
    	loop:
    	for (int i = 1; i <= n; i++) {
    		sum = i;
    		String s = String.valueOf(i);
    		for (int j = 0; j < s.length(); j++) {
    			sum += (Integer.valueOf(s.charAt(j)) - 48);
    		}
    		if (sum == n) {
				sum = i;
				break loop;
			} else {
				sum = 0;
			}
    	}
    	if (sum != 0) System.out.println(sum);
    	else System.out.println(0);
    		
    	sc.close();
    	
    }
}
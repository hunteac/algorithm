import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int s = 7;
    	int n2 = 2;
    	int cnt = 1;
    	
    	if (n > 1) cnt++;
    	
    	while (n > s) {
    		s = s + (6 * n2);
    		n2++;
    		cnt++;
    	}
    	System.out.println(cnt);
    	sc.close();
    	
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int cnt = 0;
    	
    	for (int i = 0; i < n; i++) {
    		int a = sc.nextInt();
    		int cnt2 = 0;
    		for (int j = 1; j <= a; j++) {
    			if (a % j == 0) cnt2++;
    		}
    		
    		if (cnt2 == 2) cnt++;
    	}
    	System.out.println(cnt);
    	sc.close();
    	
    }
}
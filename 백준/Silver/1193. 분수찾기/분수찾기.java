import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int cnt = 0;
        int b = 1;
        
        for (int i = 0; i < n; i++) {
        	if (n > a) {
        		n = n - a;
        		a++;
        		cnt++;
        	}
        }
        
        if (cnt % 2 == 1) {
        	while (n > 1) { 
        		cnt--;
        		b++;
        		n--;
        	}
        	System.out.printf("%d/%d", cnt, b);
        } else {
        	while (n > 1) {
        		b++;
        		cnt--;
        		n--;
        	}
        	System.out.printf("%d/%d", b, cnt);
        }
        sc.close();
        
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	long n = sc.nextLong();
        int b = sc.nextInt();
        long n2 = n;
        int b2 = b;
        int cnt = 0;
        
        while (n2 >= b2) {
        	if (n2 / b2 > 0)
        		cnt++;
        	n2 = n2 / b2;
        }
        
        long [] arr = new long[cnt + 1]; 
        
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = n % b;
        	n = n / b;
        }
        
        for (int i = arr.length; i > 0; i--) {
        	if (arr[i - 1] >= 10) {
        		System.out.print((char) (arr[i - 1] + 55));
        	} else System.out.print(arr[i - 1]);
        }
    	sc.close();
    	
    }
}
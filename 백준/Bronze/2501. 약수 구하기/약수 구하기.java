import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int p = sc.nextInt();
   		int q = sc.nextInt();
    	int a = 1;
   		int num = 0;
    	int cnt = 0;
    	int cnt2 = 0;
   		
    	// p의 약수 개수 구하기
    	while (p >= a) {
    		if (p % a == 0) cnt++;
    		a++;
    	}
    	
    	// q번째로 작은 약수 구하기
    	for (int i = 1; i <= p; i++) {
    		if (cnt >= q) {
    			if (p % i == 0) {
    				num = i;
    				cnt2++;
    			}
    			if (cnt2 == q) break;
    		}
    		else if (q > cnt) num = 0;
    	}
    	
    	System.out.println(num);
   		
    	sc.close();
    	
    }
}
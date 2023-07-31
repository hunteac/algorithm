import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] arr = new int[26];
    	String s = sc.next();
    	int max = 0;
    	int num = 0;
    	int cnt = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		if ((int) s.charAt(i) > 96)
    			arr[(int) s.charAt(i) - 97] += 1;
    		else 
    			arr[(int) s.charAt(i) - 65] += 1;
    	}
    	
    	for (int i = 0; i < 26; i++) {
    		if (arr[i] > max) {
    			max = arr[i];
    			num = i;
    		}
    	}
    	
    	for (int i = 0; i < 26; i++) {
    		if (max == arr[i]) cnt++;
    	}
    	
    	if (cnt > 1) System.out.println("?");
    	else System.out.println((char) (num + 65));
    	
   	}
}
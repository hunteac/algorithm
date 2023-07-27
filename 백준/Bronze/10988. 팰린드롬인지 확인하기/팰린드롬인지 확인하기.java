import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	boolean t = false;
    	
    	if (s.length() == 1) t = true;
    	
    	for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) == s.charAt(s.length() - i - 1))
    			t = true;
    		else {
    			t = false;
    			break;
    		}
    	}
    	
    	if (t == true) System.out.println(1);
    	else System.out.println(0);
   	}
}
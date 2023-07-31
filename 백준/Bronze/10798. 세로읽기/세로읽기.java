import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String[][] arr = new String[5][15];
    	int max = 0;
    	
    	for (int i = 0; i < 5; i++) {
    		String s = sc.next();
    		for (int j = 0; j < s.length(); j++) {
    			arr[i][j] = s.charAt(j) + "";
    			if (s.length() > max)
    				max = s.length();
    		}
    	}
    	
    	for (int i = 0; i < max; i++) {
    		for (int j = 0; j < 5; j++) {
    			if (arr[j][i] != null)
    				System.out.print(arr[j][i]);
    			else
    				System.out.print("");
    		}
    	}
    	sc.close();
    			
    }
    	
}
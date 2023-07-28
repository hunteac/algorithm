import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	int cnt = 0;
    	for (int i = 0; i < n; i++) {
    		int com = 0;
    		String s = sc.next();
    		String[] arr = s.split("");
    		
    		//1. 모든 알파벳이 다를경우
    		for (int j = 0; j < arr.length; j++) {
    			for (int k = j + 1; k < arr.length; k++) {
    				if (arr[j].equals(arr[k])) {
    					com = 2;
    				}
    			}
    		}
    		if (com == 0) cnt++;
    		
    		//2. 연속된 알파벳들의 집합
    		Loop1 :
    		for (int j = 0; j < arr.length; j++) {
    			for (int k = j + 1; k < arr.length; k++) {
    				if (arr[j].equals(arr[k])) {
    					if (k - j == 1) com = 1;
    					else if (k - j > 1 && !(arr[k].equals(arr[k - 1]))) {
    						com = 2;
    						break Loop1;
    					}
    				}
    				
    			}
    		}
    		if (com == 1) cnt++;
    	}
    	
    	System.out.println(cnt);
   	}
}
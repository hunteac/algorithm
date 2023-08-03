import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int t = sc.nextInt();
    	int[] arr = new int[n];
    	int max = 0;
    	
    	for (int i = 0; i < n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = i + 1; j < n; j++) {
    			for (int k = j + 1; k < n; k++) {
    				if (arr[i] + arr[j] + arr[k] <= t
    						&& arr[i] + arr[j] + arr[k] > max)
    					max = arr[i] + arr[j] + arr[k];
    			}
    		}
    	}
    	
    	System.out.println(max);
    	sc.close();
    	
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[][] map = new int[100][100];
    	int n = sc.nextInt();
    	int sum = 0;
    	
    	for (int i = 0; i < n; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		for (int j = a; j < a + 10; j++) {
    			for (int k = b; k < b + 10; k++) {
    				if (map[j][k] == 0) { 
    					map[j][k] = 1;
    					sum += 1;
    				}
    			}
    		}
    	}
    	
    	System.out.println(sum);
    	
    	sc.close();
    			
    }
    	
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] xarr = new int[3];
    	int[] yarr = new int[3];
    	
    	for (int i = 0; i < 3; i++) {
    		xarr[i] = sc.nextInt();
    		yarr[i] = sc.nextInt();
    	}
    	
    	for (int i = 0; i < 1; i++) {
    		if (xarr[i] == xarr[i + 1])
    			System.out.print(xarr[i + 2] + " ");
    		else if (xarr[i + 1] == xarr[i + 2])
    			System.out.print(xarr[i] + " ");
    		else 
    			System.out.print(xarr[i + 1] + " ");
    		
    		if (yarr[i] == yarr[i + 1])
    			System.out.print(yarr[i + 2]);
    		else if (yarr[i + 1] == yarr[i + 2])
    			System.out.print(yarr[i]);
    		else 
    			System.out.print(yarr[i + 1]);
    	}
    	sc.close();
    	
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int x = sc.nextInt();
    	int y = sc.nextInt();
    	int w = sc.nextInt();
    	int h = sc.nextInt();
    	int x2 = 0;
    	int y2 = 0;
    	
    	if (x >= w - x) x2 = w - x;
    	else x2 = x;
    	
    	if (y >= h - y) y2 = h - y;
    	else y2 = y;
    	
    	if (x2 >= y2) System.out.println(y2);
    	else System.out.println(x2);
    	
    	sc.close();
    }
}
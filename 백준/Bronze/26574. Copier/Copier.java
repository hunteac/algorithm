import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			System.out.print(a + " " + a);
			System.out.println();
		}
	}
}
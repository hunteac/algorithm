import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (20 <= a && a <= 23) {
			System.out.println(24 - a + b);
		} else {
			System.out.println(b - a);
		}
	}
}
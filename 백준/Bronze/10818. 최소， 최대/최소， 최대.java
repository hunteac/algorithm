import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = -1000000;
		int min = 1000000;
		
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a >= max) {
				max = a;
			} 
			if (a <= min) {
				min = a;
			}
		}
		System.out.printf("%d %d", min, max);
	}
}
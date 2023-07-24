import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String star = "*";

		for (int i = t - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < t - i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}

		sc.close();

	}
}
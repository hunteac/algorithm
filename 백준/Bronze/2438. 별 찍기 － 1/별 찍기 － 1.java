import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String star = "*";

		for (int i = 1; i <= t; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}

		sc.close();

	}
}
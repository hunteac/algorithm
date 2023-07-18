import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (b >= 45){
			b -= 45;
			System.out.printf("%d %d", a, b);
		} else if (a == 0 && b < 45) {
			a += 23;
			b += 15;
			System.out.printf("%d %d", a, b);
		} else {
			a -= 1;
			b += 15;
			System.out.printf("%d %d", a, b);
		}
	}
}